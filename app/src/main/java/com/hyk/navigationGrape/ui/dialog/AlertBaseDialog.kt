package com.hyk.navigationGrape.ui.dialog

import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.DialogAlertBaseBinding
import com.hyk.navigationGrape.extends.empty
import com.hyk.navigationGrape.ui.base.BaseDialogFragment

class AlertBaseDialog : BaseDialogFragment<DialogAlertBaseBinding>() {

    override val layoutId: Int
        get() = R.layout.dialog_alert_base

    override val gravity: Int
        get() = Gravity.CENTER

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isAdded)
            return

        dialog?.setOnDismissListener {
            callBackListener.invoke(false)
        }

        binding.tvTitle.visibility = View.VISIBLE
        binding.tvTitle.text = arguments?.getString(TITLE) ?: String.empty
        binding.tvContent.text = arguments?.getString(CONTENT)

        binding.tvOk.apply {
            text = arguments?.getString(OK_NAME)
            setOnClickListener {
                callBackListener.invoke(true)
                dismissAllowingStateLoss()
            }
        }
    }

    companion object {
        const val TAG = "alertDialog"

        private const val TITLE = "TITLE"
        private const val CONTENT = "CONTENT"
        private const val OK_NAME = "OK_NAME"

        private lateinit var callBackListener: (Boolean) -> Unit

        fun newInstance(
            title: String = String.empty,
            content: String = String.empty,
            okName: String = String.empty,
            func: (Boolean) -> Unit
        ): AlertBaseDialog {

            callBackListener = func

            val args = Bundle()
            args.putString(TITLE, title)
            args.putString(CONTENT, content)
            args.putString(OK_NAME, okName)

            val fragment = AlertBaseDialog()
            fragment.arguments = args
            return fragment
        }
    }
}
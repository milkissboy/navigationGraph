package com.hyk.navigationGrape.extends

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.hyk.navigationGrape.extends.Logger.d
import com.hyk.navigationGrape.ui.dialog.AlertBaseDialog

fun Fragment.showCustomAlert(
    @StringRes title: Int = 0,
    @StringRes content: Int = 0,
    @StringRes okName: Int = 0
) {
    activity?.let {
        showCustomAlert(getString(title), getString(content), getString(okName))
    }
}

fun Fragment.showCustomAlert(
    title: String = String.empty,
    content: String,
    okName: String = String.empty
) {
    activity?.let {
        it.customAlert(title, content, okName) { isCancel ->
            d("abbabab $isCancel")
        }
    }
}

private fun FragmentActivity.customAlert(
    title: String = String.empty,
    content: String = String.empty,
    okName: String = String.empty,
    func: (Boolean) -> Unit
) {
    if (!isFinishing) {
        val dialog = AlertBaseDialog.newInstance(
            title,
            content,
            okName,
            func
        )
        dialog.show(supportFragmentManager, AlertBaseDialog.TAG)
    }
}
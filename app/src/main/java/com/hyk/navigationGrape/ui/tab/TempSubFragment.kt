package com.hyk.navigationGrape.ui.tab

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.hyk.navigationGrape.BuildConfig
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.FragmentMainSubBinding
import com.hyk.navigationGrape.extends.Logger.w
import com.hyk.navigationGrape.extends.empty
import com.hyk.navigationGrape.ui.base.BasePlainFragment

class TempSubFragment : BasePlainFragment<FragmentMainSubBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_main_sub

    private val arguments: TempSubFragmentArgs by navArgs()

    private var text: String = String.empty

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initArgs()
    }

    private fun initArgs() {
        arguments.apply {
            this@TempSubFragment.text = title
            if (BuildConfig.DEBUG) {
                w("get text : ", text)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = text
    }
}
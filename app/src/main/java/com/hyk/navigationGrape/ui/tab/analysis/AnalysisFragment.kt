package com.hyk.navigationGrape.ui.tab.analysis

import android.os.Bundle
import android.view.View
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.FragmentMainAnalysisBinding
import com.hyk.navigationGrape.ui.base.BasePlainFragment

class AnalysisFragment : BasePlainFragment<FragmentMainAnalysisBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_main_analysis

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bt.setOnClickListener {
            moveScreen(AnalysisFragmentDirections.actionMainToSub("bbbb sub"))
        }
    }
}
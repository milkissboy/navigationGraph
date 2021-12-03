package com.hyk.navigationGrape.ui.tab.insight

import android.os.Bundle
import android.view.View
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.FragmentMainInsightBinding
import com.hyk.navigationGrape.ui.base.BasePlainFragment

class InsightFragment : BasePlainFragment<FragmentMainInsightBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_main_insight

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bt.setOnClickListener {
            moveScreen(InsightFragmentDirections.actionMainToSub("cccc sub"))
        }
    }
}
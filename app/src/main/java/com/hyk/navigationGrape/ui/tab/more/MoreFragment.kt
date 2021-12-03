package com.hyk.navigationGrape.ui.tab.more

import android.os.Bundle
import android.view.View
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.FragmentMainMoreBinding
import com.hyk.navigationGrape.ui.base.BasePlainFragment

class MoreFragment : BasePlainFragment<FragmentMainMoreBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_main_more

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bt.setOnClickListener {
            moveScreen(MoreFragmentDirections.actionMainToSub("dddd sub"))
        }
    }
}
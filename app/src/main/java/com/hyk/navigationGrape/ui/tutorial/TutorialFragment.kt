package com.hyk.navigationGrape.ui.tutorial

import android.os.Bundle
import android.view.View
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.FragmentTutorialBinding
import com.hyk.navigationGrape.ui.base.BasePlainFragment

class TutorialFragment : BasePlainFragment<FragmentTutorialBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_tutorial

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btNext.setOnClickListener {
            moveScreen(TutorialFragmentDirections.actionTutorialToLogin())
        }

        binding.btMain.setOnClickListener {
            moveScreen(TutorialFragmentDirections.actionTutorialToMain())
        }
    }
}
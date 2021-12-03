package com.hyk.navigationGrape.ui.tab.profile

import android.os.Bundle
import android.view.View
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.FragmentMainProfileBinding
import com.hyk.navigationGrape.ui.base.BasePlainFragment
import com.hyk.navigationGrape.ui.main.MainFragmentDirections

class ProfileFragment : BasePlainFragment<FragmentMainProfileBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_main_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bt.setOnClickListener {
            moveScreen(ProfileFragmentDirections.actionMainToSub("aaaa sub"))
        }

        binding.bt2.setOnClickListener {
            moveScreenGlobal(MainFragmentDirections.actionProfileToSub2())
        }
    }
}
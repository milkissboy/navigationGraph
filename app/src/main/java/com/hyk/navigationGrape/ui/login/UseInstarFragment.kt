package com.hyk.navigationGrape.ui.login

import android.os.Bundle
import android.view.View
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.FragmentUseInstarBinding
import com.hyk.navigationGrape.extends.Logger.d
import com.hyk.navigationGrape.ui.base.BasePlainFragment

class UseInstarFragment : BasePlainFragment<FragmentUseInstarBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_use_instar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvInstar.setOnClickListener {
            moveScreen(UseInstarFragmentDirections.actionUseInstarToMain())
        }

        binding.tvRetry.setOnClickListener {
            d("in 2")
        }
    }
}
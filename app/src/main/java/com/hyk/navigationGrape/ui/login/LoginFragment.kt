package com.hyk.navigationGrape.ui.login

import android.os.Bundle
import android.view.View
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.FragmentLoginBinding
import com.hyk.navigationGrape.ui.base.BasePlainFragment

class LoginFragment : BasePlainFragment<FragmentLoginBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvKakao.setOnClickListener {
            moveScreen(LoginFragmentDirections.actionLoginToUse())
        }
    }
}
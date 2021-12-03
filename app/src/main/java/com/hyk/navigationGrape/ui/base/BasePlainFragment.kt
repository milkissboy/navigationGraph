package com.hyk.navigationGrape.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.ui.main.MainActivity

abstract class BasePlainFragment<T : ViewDataBinding> : Fragment() {

    //var globalNavController: NavController? = null

    protected lateinit var binding: T

    abstract val layoutResId: Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<T>(inflater, layoutResId, container, false).apply {
        binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*globalNavController =
            Navigation.findNavController(requireActivity(), R.id.navigation_main_host)*/

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    onBackPressed()
                }
            })
    }

    private fun getMainActivity(): MainActivity? {
        return if (activity is MainActivity) activity as MainActivity
        else null
    }

    /*fun getMainFragment(): MainFragment? {
        return getMainActivity()?.getMainFragment()
    }*/

    open fun onBackPressed() {
        findNavController().popBackStack()
    }

    protected fun moveScreen(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    protected fun moveScreenGlobal(directions: NavDirections) {
        getMainActivity()?.findNavController(R.id.navigation_main_host)?.navigate(directions)
        //getMainActivity()?.navigate(directions)
    }
}
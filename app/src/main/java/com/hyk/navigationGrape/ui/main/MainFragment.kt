package com.hyk.navigationGrape.ui.main

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.FragmentMainBinding
import com.hyk.navigationGrape.extends.Logger
import com.hyk.navigationGrape.extends.showCustomAlert
import com.hyk.navigationGrape.ui.base.BasePlainFragment

class MainFragment : BasePlainFragment<FragmentMainBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_main

    private val hosts =
        arrayListOf(R.id.host_profile, R.id.host_analysis, R.id.host_insight, R.id.host_more)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // todo test
        showCustomAlert(
            "title",
            "content",
            "ok"
        )

        setupUI()
        setupListener()

        binding.viewPager.apply {
            adapter = MainViewPagerAdapter(binding.layoutBottom.childCount)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    //viewModel.setTitleYearMonth(position)
                }
            })
        }
    }

    private fun setupUI() {
        selectBottom(0)
    }

    private fun setupListener() {
        binding.bottom1.setOnClickListener {
            selectBottom(0)
        }

        binding.bottom2.setOnClickListener {
            selectBottom(1)
        }

        binding.bottom3.setOnClickListener {
            selectBottom(2)
        }

        binding.bottom4.setOnClickListener {
            selectBottom(3)
        }
    }

    private fun selectBottom(position: Int) {
        Logger.i("bottom position : $position")
        binding.viewPager.setCurrentItem(position, false)
        binding.layoutBottom.children.forEachIndexed { index, view ->
            if (view is ConstraintLayout) {
                val alpha = if (index == position) 1.0f else 0.2f
                view.children.forEach {
                    if (it is ImageView) {
                        it.alpha = alpha
                    } else if (it is TextView) {
                        it.alpha = alpha
                    }
                }
            }
        }
    }

    fun popStack(): Boolean {
        //val v = binding.viewPager[binding.viewPager.currentItem]
        Navigation.findNavController(requireActivity(), hosts[binding.viewPager.currentItem]).also {
            val current = it.currentDestination?.id ?: 0
            return if (current == R.id.profileFragment || current == R.id.analysisFragment
                || current == R.id.insightFragment || current == R.id.moreFragment
            ) {
                //onBackPressed()
                false
            } else {
                it.popBackStack()
                true
            }
        }
    }
}
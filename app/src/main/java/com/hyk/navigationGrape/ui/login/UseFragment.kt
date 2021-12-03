package com.hyk.navigationGrape.ui.login

import android.os.Bundle
import android.view.View
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.databinding.FragmentUseBinding
import com.hyk.navigationGrape.ui.base.BasePlainFragment
import kotlin.math.abs

class UseFragment : BasePlainFragment<FragmentUseBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_use

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvInstar.setOnClickListener {
            moveScreen(UseFragmentDirections.actionUseToInstar())
        }

        binding.viewPager2.adapter = UseInfoAdapter()


        // 관리하는 페이지 수. default = 1
        binding.viewPager2.offscreenPageLimit = 4
        // item_view 간의 양 옆 여백을 상쇄할 값
        val offsetBetweenPages =
            resources.getDimensionPixelOffset(R.dimen.offsetBetweenPages).toFloat()
        binding.viewPager2.setPageTransformer { page, position ->
            val myOffset = position * -(2 * offsetBetweenPages)
            if (position < -1) {
                page.translationX = -myOffset
            } else if (position <= 1) {
                // Paging 시 Y축 Animation 배경색을 약간 연하게 처리
                val scaleFactor = 0.8f.coerceAtLeast(1 - abs(position))
                page.translationX = myOffset
                //page.scaleY = scaleFactor
                page.alpha = scaleFactor
            } else {
                page.alpha = 0f
                page.translationX = myOffset
            }
        }

        binding.dotsIndicator.setViewPager2(binding.viewPager2)
    }
}
package com.hyk.navigationGrape.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hyk.navigationGrape.R
import com.hyk.navigationGrape.extends.Logger

class MainViewPagerAdapter(private val total: Int) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        Logger.i("holder : ${viewType}")

        val layoutId = when(viewType) {
            1 -> R.layout.fragment_main_item_analysis
            2 -> R.layout.fragment_main_item_insight
            3 -> R.layout.fragment_main_item_more
            else -> R.layout.fragment_main_item_profile
        }


        return object : ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(layoutId, parent, false)
        ) {
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position //super.getItemViewType(position)
    }

    override fun getItemCount() = total

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }
}

package com.hyk.navigationGrape.ui.login

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hyk.navigationGrape.R

class UseInfoAdapter : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return object : ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_use_vp_item, parent, false)
        ) {
        }
    }

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tv_num).text = (position + 1).toString()
    }
}

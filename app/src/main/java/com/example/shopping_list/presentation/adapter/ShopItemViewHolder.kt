package com.example.shopping_list.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_list.R


class ShopListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val tvName: TextView = itemView.findViewById(R.id.tv_name)
    val tvCount: TextView = itemView.findViewById(R.id.tv_count)
}
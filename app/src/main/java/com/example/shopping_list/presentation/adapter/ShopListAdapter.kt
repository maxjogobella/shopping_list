package com.example.shopping_list.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shopping_list.R
import com.example.shopping_list.domain.ShopItem

class ShopListAdapter : Adapter<ShopListAdapter.ShopListViewHolder>() {

    var count = 0

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {
        Log.d("ShopListAdapter", "onCreateViewHolder, count: ${count++}")
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
        return ShopListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int) {
        val shopItem = shopList[position]
        holder.itemView.setOnLongClickListener {
            true
        }

        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
    }

    override fun onViewRecycled(holder: ShopListViewHolder) {
        super.onViewRecycled(holder)
        holder.tvName.text = ""
        holder.tvCount.text = ""
    }

    override fun getItemViewType(position: Int): Int {
        val item = shopList[position]
        return if (item.enabled) {
            R.layout.item_shop_enabled
        } else {
            R.layout.item_shop_disenabled
        }
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    inner class ShopListViewHolder(itemView : View) : ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tv_name)
        val tvCount = itemView.findViewById<TextView>(R.id.tv_count)
    }

    companion object {
        const val MAX_POOL_SIZE = 15
    }
}
package com.example.shopping_list.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.shopping_list.domain.ShopItem

class ShopListDiffCallback(
    private val oldlist : List<ShopItem>,
    private val newlist : List<ShopItem>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldlist.size

    override fun getNewListSize(): Int = newlist.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldlist[oldItemPosition]
        val newItem = newlist[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldlist[oldItemPosition]
        val newItem = newlist[newItemPosition]
        return oldItem == newItem
    }
}
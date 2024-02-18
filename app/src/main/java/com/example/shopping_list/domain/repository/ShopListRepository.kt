package com.example.shopping_list.domain.repository

import androidx.lifecycle.LiveData
import com.example.shopping_list.domain.model.ShopItem

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId : Int) : ShopItem
    fun getShopList() : LiveData<List<ShopItem>>
    fun removeItem(shopItem: ShopItem)

}
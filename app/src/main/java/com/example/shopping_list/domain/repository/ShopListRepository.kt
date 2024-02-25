package com.example.shopping_list.domain.repository

import androidx.lifecycle.LiveData
import com.example.shopping_list.domain.model.ShopItem

interface ShopListRepository {
    suspend fun addShopItem(shopItem: ShopItem)
    suspend fun editShopItem(shopItem: ShopItem)
    suspend fun getShopItem(shopItemId : Int) : ShopItem
    fun getShopList() : LiveData<List<ShopItem>>
   suspend fun removeItem(shopItem: ShopItem)

}
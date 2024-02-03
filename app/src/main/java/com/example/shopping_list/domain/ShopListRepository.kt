package com.example.shopping_list.domain

import androidx.lifecycle.LiveData
import com.example.shopping_list.data.ShopListRepositoryImpl

interface ShopListRepository {
    fun addShopList(shopItem: ShopItem) {}
    fun editShopList(shopItem: ShopItem)
    fun getShopItem(shopItemId : Int) : ShopItem
    fun getShopList() : LiveData<List<ShopItem>>
    fun removeList(shopItem: ShopItem)

}
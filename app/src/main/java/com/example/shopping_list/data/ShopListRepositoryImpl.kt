package com.example.shopping_list.data

import androidx.lifecycle.LiveData
import com.example.shopping_list.data.local.DatabaseProvider
import com.example.shopping_list.data.local.ShopDatabase
import com.example.shopping_list.domain.ShopItem
import com.example.shopping_list.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val database = DatabaseProvider.database.shopDao()
    override fun addShopList(shopItem: ShopItem) {
        database.addItem(shopItem)
    }

    override fun editShopList(shopItem: ShopItem) {
        TODO("Not yet implemented")
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return database.getShopItem(shopItemId)
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return database.getShopList()
    }

    override fun removeList(shopItem: ShopItem) {
        database.removeItem(shopItem.id)
    }
}
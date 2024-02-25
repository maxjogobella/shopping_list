package com.example.shopping_list.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.shopping_list.data.local.database.ShopDatabase
import com.example.shopping_list.domain.model.ShopItem
import com.example.shopping_list.domain.repository.ShopListRepository

class ShopListRepositoryImpl(
    application : Application
) : ShopListRepository {

    private val shopListDao = ShopDatabase.getInstance(application).shopDao()

    override fun addShopItem(shopItem: ShopItem) {
       shopListDao.addItem(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }
    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId
            } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun removeItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    private fun updateList() {
        shopListLD.value = shopList.sortedBy { it.id }.toList()
    }
}
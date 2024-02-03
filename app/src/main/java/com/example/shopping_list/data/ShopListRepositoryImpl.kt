package com.example.shopping_list.data

import com.example.shopping_list.domain.ShopItem
import com.example.shopping_list.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    private var autoIncrementId = 0

    override fun editShopList(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }
    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find { it.id == shopItemId
            } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

    override fun removeList(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }
}
package com.example.shopping_list.data.local.model.mapper

import com.example.shopping_list.data.local.model.ShopItemDb
import com.example.shopping_list.domain.model.ShopItem

class ShopListMapper {

    fun mapEntityToDbModel(shopItem: ShopItem) : ShopItemDb = ShopItemDb(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )

    fun mapDbModelToEntity(shopItemDb: ShopItemDb) : ShopItem = ShopItem(
        id = shopItemDb.id,
        name = shopItemDb.name,
        count = shopItemDb.count,
        enabled = shopItemDb.enabled
    )

    fun mapListDbModelToListEntity(list : List<ShopItemDb>) = list.map {
        mapDbModelToEntity(it)
    }


}
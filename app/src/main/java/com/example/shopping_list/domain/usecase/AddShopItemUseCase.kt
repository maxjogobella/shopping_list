package com.example.shopping_list.domain.usecase

import com.example.shopping_list.domain.model.ShopItem
import com.example.shopping_list.domain.repository.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopList(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }

}
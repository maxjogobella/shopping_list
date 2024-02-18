package com.example.shopping_list.domain.usecase

import com.example.shopping_list.domain.model.ShopItem
import com.example.shopping_list.domain.repository.ShopListRepository

class RemoveShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun removeItem(shopItem: ShopItem) {
        shopListRepository.removeItem(shopItem)
    }

}
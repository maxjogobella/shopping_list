package com.example.shopping_list.domain

class RemoveShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun removeItem(shopItem: ShopItem) {
        shopListRepository.removeItem(shopItem)
    }

}
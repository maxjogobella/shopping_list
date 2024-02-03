package com.example.shopping_list.domain

class RemoveShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun removeList(shopItem: ShopItem) {
        shopListRepository.removeList(shopItem)
    }

}
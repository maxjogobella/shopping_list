package com.example.shopping_list.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopList(shopItem: ShopItem) {
        shopListRepository.addShopList(shopItem)
    }

}
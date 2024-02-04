package com.example.shopping_list.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopList(shopItem: ShopItem) {
        shopListRepository.editShopList(shopItem)
    }

}
package com.example.shopping_list.domain.usecase

import com.example.shopping_list.domain.model.ShopItem
import com.example.shopping_list.domain.repository.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    suspend fun getShopItem(shopItemId : Int) : ShopItem = shopListRepository.getShopItem(shopItemId)


}
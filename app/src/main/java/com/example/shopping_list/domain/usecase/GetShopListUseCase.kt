package com.example.shopping_list.domain.usecase

import androidx.lifecycle.LiveData
import com.example.shopping_list.domain.model.ShopItem
import com.example.shopping_list.domain.repository.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList() : LiveData<List<ShopItem>> = shopListRepository.getShopList()

}
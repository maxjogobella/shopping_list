package com.example.shopping_list.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shopping_list.data.ShopListRepositoryImpl
import com.example.shopping_list.domain.usecase.EditShopItemUseCase
import com.example.shopping_list.domain.usecase.GetShopListUseCase
import com.example.shopping_list.domain.usecase.RemoveShopItemUseCase
import com.example.shopping_list.domain.model.ShopItem

class MainViewModel : ViewModel() {

    /*
     * Presentation слой не должен знать об Data, но сейчас нет возможности сделать по-другому
     * т.к для этого нужно знать об Dagger
     */

    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun removeShopItem(showItem: ShopItem) {
        deleteShopItemUseCase.removeItem(showItem)
    }

    fun changeEnambledState(showItem: ShopItem) {
        val newItem = showItem.copy(enabled = !showItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}
package com.example.shopping_list.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopping_list.data.ShopListRepositoryImpl
import com.example.shopping_list.domain.EditShopItemUseCase
import com.example.shopping_list.domain.GetShopListUseCase
import com.example.shopping_list.domain.RemoveShopItemUseCase
import com.example.shopping_list.domain.ShopItem

class MainViewModel : ViewModel() {

    /*
     * Presentation слой не должен знать об Data, но сейчас нет возможности сделать по-другому
     * т.к для этого нужно знать об Dagger
     */

    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = MutableLiveData<List<ShopItem>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }

}
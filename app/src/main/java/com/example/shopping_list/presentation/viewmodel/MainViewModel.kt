package com.example.shopping_list.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping_list.data.ShopListRepositoryImpl
import com.example.shopping_list.domain.usecase.EditShopItemUseCase
import com.example.shopping_list.domain.usecase.GetShopListUseCase
import com.example.shopping_list.domain.usecase.RemoveShopItemUseCase
import com.example.shopping_list.domain.model.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainViewModel(application : Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)


    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun removeShopItem(showItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.removeItem(showItem)
        }
    }

    fun changeEnambledState(showItem: ShopItem) {
        viewModelScope.launch {
            val newItem = showItem.copy(enabled = !showItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }

}
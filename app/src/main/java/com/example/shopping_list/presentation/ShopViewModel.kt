package com.example.shopping_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shopping_list.data.ShopListRepositoryImpl
import com.example.shopping_list.domain.AddShopItemUseCase
import com.example.shopping_list.domain.EditShopItemUseCase
import com.example.shopping_list.domain.GetShopItemUseCase
import com.example.shopping_list.domain.ShopItem

class ShopViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)

    private val _errorInputName = MutableLiveData<Boolean>()
    private val _errorCountName = MutableLiveData<Boolean>()
    private val _shopItem = MutableLiveData<ShopItem>()
    private val _shouldCloseScreen = MutableLiveData<Unit>()

    val shouldCloseScreen : LiveData<Unit>
        get() = _shouldCloseScreen
    val shopItemLd : LiveData<ShopItem>
        get() = _shopItem

    val errorCountName : LiveData<Boolean>
        get() = _errorCountName
    val errorInputName : LiveData<Boolean>
        get() = _errorInputName

    val shopList = repository.getShopList()

    fun addShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fielsValid = validateInput(name, count)
        if (fielsValid) {
            val shopItem = ShopItem(name, count, enabled = true)
            addShopItemUseCase.addShopList(shopItem)
            finishWork()
        }
    }
    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fielsValid = validateInput(name, count)
        if (fielsValid) {
            _shopItem.value?.let {
                val item = it.copy(name = name, count = count)
                editShopItemUseCase.editShopItem(item)
                finishWork()
            }
        }
    }

    fun getShopItem(shopItem: ShopItem) {
        val item = getShopItemUseCase.getShopItem(shopItem.id)
        _shopItem.value = item
    }

    private fun parseName(inputName: String?) = inputName?.trim() ?: ""
    private fun parseCount(inputCount: String?) : Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e : Exception) {
            0
        }
    }

    private fun validateInput(name : String, count : Int) : Boolean {
        val result = true

        if (name.isBlank()) {
            _errorInputName.value = true
            return false
        }
        if (count <= 0) {
            _errorCountName.value = true
        }
        return result
    }

    fun resetErrorInputName() {
        _errorInputName.value = false
    }

    fun resetErrorCount() {
        _errorCountName.value = false
    }

    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }
}
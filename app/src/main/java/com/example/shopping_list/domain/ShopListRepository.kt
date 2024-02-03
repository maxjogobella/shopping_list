package com.example.shopping_list.domain

interface ShopListRepository {

    fun addShopList(shopItem: ShopItem) {
        TODO()
    }

    fun editShopList(shopItem: ShopItem) {
        TODO()
    }

    fun getShopItem(shopItemId : Int) : ShopItem {
        TODO()
    }

    fun getShopList() : List<ShopItem> {
        TODO()
    }

    fun removeList(shopItem: ShopItem) {
        TODO()
    }

}
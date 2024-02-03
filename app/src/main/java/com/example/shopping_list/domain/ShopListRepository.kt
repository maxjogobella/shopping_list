package com.example.shopping_list.domain

interface ShopListRepository {
    fun addShopList(shopItem: ShopItem)
    fun editShopList(shopItem: ShopItem)
    fun getShopItem(shopItemId : Int) : ShopItem
    fun getShopList() : List<ShopItem>
    fun removeList(shopItem: ShopItem)

}
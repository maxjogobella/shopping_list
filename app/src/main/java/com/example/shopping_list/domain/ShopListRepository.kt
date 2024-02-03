package com.example.shopping_list.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun editShopList(shopItem: ShopItem)
    fun getShopItem(shopItemId : Int) : ShopItem
    fun getShopList() : List<ShopItem>
    fun removeItem(shopItem: ShopItem)

}
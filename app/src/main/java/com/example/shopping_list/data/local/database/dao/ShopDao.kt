package com.example.shopping_list.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.shopping_list.data.local.model.ShopItemDb
import com.example.shopping_list.domain.model.ShopItem
import io.reactivex.rxjava3.core.Completable


@Dao
interface ShopDao {
    @Insert
    fun addItem(shopItem: ShopItemDb) : Completable

    @Query("DELETE FROM shop_items WHERE id=:shopItemId")
    fun removeItem(shopItemId: Int) : Completable

    @Query("SELECT * FROM shop_items")
    fun getShopList() : LiveData<List<ShopItemDb>>

    @Query("SELECT * FROM shop_items WHERE id=:shopItemId")
    fun getShopItem(shopItemId: Int) : LiveData<ShopItemDb>

}
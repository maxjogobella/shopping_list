package com.example.shopping_list.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shopping_list.data.local.model.ShopItemDb

@Dao
interface ShopDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(shopItem: ShopItemDb)
    @Query("DELETE FROM shop_items WHERE id=:shopItemId")
    suspend fun removeItem(shopItemId: Int)

    @Query("SELECT * FROM shop_items")
    fun getShopList() : LiveData<List<ShopItemDb>>

    @Query("SELECT * FROM shop_items WHERE id=:shopItemId LIMIT 1")
    suspend fun getShopItem(shopItemId: Int) : ShopItemDb
}
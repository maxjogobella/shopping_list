package com.example.shopping_list.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.shopping_list.domain.ShopItem
import io.reactivex.rxjava3.core.Completable

@Dao
interface ShopDao {
    @Insert
    fun addItem(shopItem: ShopItem) : Completable

    @Query("DELETE FROM shopitem_table WHERE id=:shopItemId LIMIT 1")
    fun removeItem(shopItemId: Int) : Completable

    @Query("SELECT * FROM shopitem_table")
    fun getShopList() : LiveData<List<ShopItem>>

    @Query("SELECT * FROM shopitem_table WHERE id=:shopItemId LIMIT 1")
    fun getShopItem(shopItemId: Int) : LiveData<ShopItem>

}
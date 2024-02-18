package com.example.shopping_list.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.shopping_list.domain.model.ShopItem
import io.reactivex.rxjava3.core.Completable


@Dao
interface ShopDao {
    @Insert
    fun addItem(shopItem: ShopItem) : Completable

    @Query("DELETE FROM shopitem_table WHERE id=:shopItemId")
    fun removeItem(shopItemId: Int) : Completable

    @Query("SELECT * FROM shopitem_table")
    fun getShopList() : LiveData<List<ShopItem>>

    @Query("SELECT * FROM shopitem_table WHERE id=:shopItemId")
    fun getShopItem(shopItemId: Int) : LiveData<ShopItem>

}
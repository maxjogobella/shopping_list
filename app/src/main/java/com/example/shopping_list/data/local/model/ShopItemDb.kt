package com.example.shopping_list.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("shop_items")
data class ShopItemDb(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val count : Int,
    val enabled : Boolean,
)


package com.example.shopping_list.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("shopitem_table")
data class ShopItem(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val count : Int,
    val enabled : Boolean
)
package com.example.shopping_list.data.local

import android.content.Context

object DatabaseProvider {
    lateinit var database : ShopDatabase
    fun initialize(context: Context) {
        database = ShopDatabase.getInstance(context)
    }
}
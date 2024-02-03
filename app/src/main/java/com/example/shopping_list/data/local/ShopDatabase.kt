package com.example.shopping_list.data.local

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class ShopDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "shoplist.db"
        private var db : ShopDatabase? = null
        fun getInstance(context: Context) : ShopDatabase {
            db?.let { return it }
            val instance = Room.databaseBuilder(
                context,
                ShopDatabase::class.java,
                DATABASE_NAME
            ).build()
            db = instance
            return instance
        }
    }

}
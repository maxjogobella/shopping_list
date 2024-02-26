package com.example.shopping_list.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shopping_list.data.local.database.dao.ShopDao
import com.example.shopping_list.data.local.model.ShopItemDb

@Database(entities = [ShopItemDb::class], version = 1, exportSchema = false)
abstract class ShopDatabase : RoomDatabase() {
    

    companion object {
        private const val DATABASE_NAME = "shoplist.db"
        private var INSTANCE : ShopDatabase? = null
        fun getInstance(context: Context) : ShopDatabase {
            INSTANCE?.let { return it }
            synchronized(this) {
                INSTANCE?.let {
                    return it
                }
                val instance = Room.databaseBuilder(
                    context,
                    ShopDatabase::class.java,
                    DATABASE_NAME
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
    abstract fun shopDao() : ShopDao
}
package com.example.shopping_list.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.example.shopping_list.data.local.database.ShopDatabase
import com.example.shopping_list.data.local.model.ShopItemDb
import com.example.shopping_list.data.local.model.mapper.ShopListMapper
import com.example.shopping_list.domain.model.ShopItem
import com.example.shopping_list.domain.repository.ShopListRepository

class ShopListRepositoryImpl(
    application : Application
) : ShopListRepository {

    private val shopListDao = ShopDatabase.getInstance(application).shopDao()
    private val mapper = ShopListMapper()

    override fun addShopItem(shopItem: ShopItem) {
       shopListDao.addItem(mapper.mapEntityToDbModel(shopItem))
    }

    override fun editShopItem(shopItem: ShopItem) {
        shopListDao.addItem(mapper.mapEntityToDbModel(shopItem))
    }
    override fun getShopItem(shopItemId: Int): ShopItem {
        val dbModel = shopListDao.getShopItem(shopItemId)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun getShopList(): LiveData<List<ShopItem>> = MediatorLiveData<List<ShopItem>>().apply {
        addSource(shopListDao.getShopList()) {
            value = mapper.mapListDbModelToListEntity(it)
        }
    }

    override fun removeItem(shopItem: ShopItem) {
        shopListDao.removeItem(shopItem.id)
    }
}
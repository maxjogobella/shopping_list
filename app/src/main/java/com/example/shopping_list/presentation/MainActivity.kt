package com.example.shopping_list.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.shopping_list.R
import com.example.shopping_list.presentation.adapter.ShopListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var shopListAdapter : ShopListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setUpRecyclerView()

        viewModel.shopList.observe(this) {list ->
            shopListAdapter.shopList = list
        }

    }

    private fun setUpRecyclerView() {
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        shopListAdapter = ShopListAdapter()
        with(rvShopList) {
            adapter = shopListAdapter
            recycledViewPool.setMaxRecycledViews(
                R.layout.item_shop_enabled,
                ShopListAdapter.MAX_POOL_SIZE
            )
            recycledViewPool.setMaxRecycledViews(
                R.layout.item_shop_disenabled,
                ShopListAdapter.MAX_POOL_SIZE
            )
        }

        shopListAdapter.onLongShopItemClickListener = {shopItem ->
            viewModel.changeEnambledState(shopItem)
        }

        shopListAdapter.onShopItemClickListener = {shopItem ->
            Log.d("MAINACTIVITY", shopItem.toString())
        }
    }
}
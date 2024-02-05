package com.example.shopping_list.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopping_list.R

class ShopItemActivity : AppCompatActivity() {

    private lateinit var viewModel : ShopViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)

    }
}
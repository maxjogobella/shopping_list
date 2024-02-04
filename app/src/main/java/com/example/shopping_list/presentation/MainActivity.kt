package com.example.shopping_list.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.shopping_list.R
import com.example.shopping_list.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var llshopList : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        llshopList = findViewById(R.id.ll_shop_list)

        viewModel.shopList.observe(this) {list ->
            showList(list)
        }
    }

    private fun showList(list : List<ShopItem>) {
        llshopList.removeAllViews()

        for (shopItem in list) {
            val view = LayoutInflater.from(this).inflate(R.layout.item_shop, llshopList, false)
            val tvName = view.findViewById<TextView>(R.id.tv_name)
            val tvCount = view.findViewById<TextView>(R.id.tv_count)

            val cardView = view.findViewById<CardView>(R.id.cardView)
            val lllayout = view.findViewById<LinearLayout>(R.id.linearlayout)

            if (!shopItem.enabled) {
                val colorId = ContextCompat.getColor(this, R.color.trans)
                cardView.cardElevation = 1 * resources.displayMetrics.density
                lllayout.setBackgroundColor(colorId)
            } else {
                val colorId = ContextCompat.getColor(this, R.color.purple_200)
                cardView.cardElevation = 4 * resources.displayMetrics.density
                lllayout.setBackgroundColor(colorId)
            }

            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
            view.setOnLongClickListener{
                viewModel.changeEnambledState(shopItem)
                true
            }

            llshopList.addView(view)
        }
    }
}
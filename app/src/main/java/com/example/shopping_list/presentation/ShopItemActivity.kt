package com.example.shopping_list.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shopping_list.R
import com.example.shopping_list.domain.ShopItem
import com.example.shopping_list.presentation.fragments.ShopItemFragment

class ShopItemActivity : AppCompatActivity() {

    private var screenMode : String = MODE_UKNOWN
    private var shopItemId : Int = ShopItem.UNDEFINED_ID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
        parseIntent()
        launchRightMode()
    }

    private fun launchRightMode() {
        val fragment = when (screenMode) {
            EXTRA_MODE_EDIT -> ShopItemFragment.newInstanceEditItem(shopItemId)
            EXTRA_MODE_ADD -> ShopItemFragment.newInstanceAddItem()
            else -> throw RuntimeException("Unknown screen mode")
        }
        supportFragmentManager.beginTransaction()
            .add(R.id.shop_item_container, fragment)
            .commit()
    }

    private fun parseIntent() {
        if (!intent.hasExtra(EXTRA_SCREEN_MODE)) {
            throw RuntimeException("Param screen mode is absent")
        }
        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)

        if (mode != EXTRA_MODE_EDIT && mode != EXTRA_MODE_ADD) {
            throw RuntimeException("Unknown screen mode $mode")
        }

        screenMode = mode

        if (screenMode == EXTRA_MODE_EDIT) {
            if (!intent.hasExtra(EXTRA_SHOP_ITEM_ID)) {
                throw RuntimeException("Param shop item id is absent")
            }
            shopItemId = intent.getIntExtra(EXTRA_SHOP_ITEM_ID, -1)
        }
    }

    companion object {
        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val EXTRA_MODE_EDIT = "mode_edit"
        private const val EXTRA_MODE_ADD = "mode_add"
        private const val EXTRA_SHOP_ITEM_ID = "extra_shop_item_id"
        private const val MODE_UKNOWN = ""

        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, EXTRA_MODE_ADD)
            return intent
        }

        fun newIntentEditItem(context: Context, shopItemId: Int): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, EXTRA_MODE_EDIT)
            intent.putExtra(EXTRA_SHOP_ITEM_ID, shopItemId)
            return intent
        }
    }
}

//parseIntent()
//viewModel = ViewModelProvider(this)[ShopViewModel::class.java]
//initViews()
//observeViewModel()
//hideErrorInInputlayout()
//
//when (screenMode) {
//    EXTRA_MODE_EDIT -> launchEditMode()
//    EXTRA_MODE_ADD -> launchAddMode()
//}
//}
//
//private fun hideErrorInInputlayout() {
//    etName.doOnTextChanged { _, star, _, count ->
//        viewModel.resetErrorInputName()
//    }
//
//    etCount.doOnTextChanged { text, start, before, count ->
//        viewModel.resetErrorCount()
//    }
//}
//
//private fun observeViewModel() {
//    viewModel.shouldCloseScreen.observe(this) {
//        finish()
//    }
//
//    viewModel.errorInputCount.observe(this) {
//        val message = if (it) {
//            getString(R.string.error_input_count)
//        } else {
//            null
//        }
//        tilCount.error = message
//    }
//
//    viewModel.errorInputName.observe(this) {
//        val message = if (it) {
//            getString(R.string.error_input_name)
//        } else {
//            null
//        }
//        tilName.error = message
//    }
//
//}
//
//private fun launchEditMode() {
//    viewModel.getShopItem(shopItemId)
//    buttonSave.setOnClickListener {
//        viewModel.editShopItem(etName.text.toString(), etCount.text.toString())
//    }
//}
//
//private fun launchAddMode() {
//    buttonSave.setOnClickListener {
//        val name = etName.text.toString()
//        val count = etCount.text.toString()
//        viewModel.addShopItem(name, count)
//    }
//}
//
//private fun parseIntent() {
//    if (!intent.hasExtra(EXTRA_SCREEN_MODE)) {
//        throw RuntimeException("Param screen mode is absent")
//    }
//    val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
//
//    if (mode != EXTRA_MODE_EDIT && mode != EXTRA_MODE_ADD) {
//        throw RuntimeException("Unknown screen mode $mode")
//    }
//
//    screenMode = mode
//
//    if (screenMode == EXTRA_MODE_EDIT) {
//        if (!intent.hasExtra(EXTRA_SHOP_ITEM_ID)) {
//            throw RuntimeException("Param shop item id is absent")
//        }
//        shopItemId = intent.getIntExtra(EXTRA_SHOP_ITEM_ID, -1)
//    }
//}
//
//private fun initViews() { // лучше view binding, но в уроки используестя FVBI
//    tilName = findViewById(R.id.til_name)
//    tilCount = findViewById(R.id.til_count)
//    etName = findViewById(R.id.et_name)
//    etCount = findViewById(R.id.et_count)
//    buttonSave = findViewById(R.id.save_button)
//}
//
//}

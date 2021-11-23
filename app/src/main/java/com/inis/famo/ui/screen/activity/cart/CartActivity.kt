package com.inis.famo.ui.screen.activity.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.inis.famo.R
import com.inis.famo.databinding.ActivityCartBinding
import com.inis.famo.ui.base.BaseActivity

class CartActivity : BaseActivity<ActivityCartBinding,CartViewModel>(R.layout.activity_cart) {

    companion object {
        @JvmStatic
        fun intent(context: Context): Intent {
            return Intent(context, CartActivity::class.java)
        }
    }

    override fun viewModelClass() = CartViewModel::class.java

    override fun ActivityCartBinding.initView() {

    }

    override fun ActivityCartBinding.addEvent() {

    }

    override fun CartViewModel.observeLiveData() {

    }
}
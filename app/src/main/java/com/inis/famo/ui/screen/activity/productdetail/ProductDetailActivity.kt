package com.inis.famo.ui.screen.activity.productdetail

import android.content.Context
import android.content.Intent
import com.inis.famo.R
import com.inis.famo.databinding.ActivityProductDetailBinding
import com.inis.famo.ui.base.BaseActivity

class ProductDetailActivity :
    BaseActivity<ActivityProductDetailBinding, ProductDetailViewModel>(R.layout.activity_product_detail) {

    companion object {
        @JvmStatic
        fun intent(context: Context): Intent {
            return Intent(context, ProductDetailActivity::class.java)
        }
    }

    override fun viewModelClass() = ProductDetailViewModel::class.java

    override fun ActivityProductDetailBinding.initView() {

    }

    override fun ActivityProductDetailBinding.addEvent() {

    }

    override fun ProductDetailViewModel.observeLiveData() {

    }
}
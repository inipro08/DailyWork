package com.inis.famo.ui.screen.fragment.home.tab

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.inis.famo.R
import com.inis.famo.data.model.ProductEntity
import com.inis.famo.databinding.TabBinding
import com.inis.famo.ui.adapter.HomeProductAdapter
import com.inis.famo.ui.base.BaseFragment
import com.inis.famo.ui.screen.fragment.home.HomeViewModel

class TabProductFragment(val listProduct: ArrayList<ProductEntity>)
    : BaseFragment<TabBinding, TabViewModel>(R.layout.fragment_home_tab_product) {

    companion object {
        const val TAG = "TabProductFragment"
    }

    override fun viewModelClass() = TabViewModel::class.java

    private var homeProductAdapter: HomeProductAdapter? = null

    @SuppressLint("CheckResult")
    override fun TabBinding.initComponents() {
        homeProductAdapter = HomeProductAdapter(
            context = requireContext(),
            onItemClick = ::onProductClickDetail,
            onFavoritesClick = ::onFavoritesClick,
            onBuyClick = ::onBuyClick
        )
        homeProductAdapter?.submitList(list = listProduct)
        binding.rcvTabProduct.adapter = homeProductAdapter
    }

    @SuppressLint("StringFormatMatches")
    override fun observeLiveData() {

    }

    override fun TabBinding.addEvent() {

    }

    private fun onProductClickDetail(productEntity: ProductEntity) {
        Toast.makeText(
            requireContext(),
            "Product is ${productEntity.product_name}",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun onFavoritesClick(productEntity: ProductEntity) {
        Toast.makeText(
            requireContext(),
            "Favorites ${productEntity.product_name}",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun onBuyClick(productEntity: ProductEntity) {
        Toast.makeText(requireContext(), "Buy ${productEntity.product_name}", Toast.LENGTH_SHORT)
            .show()
    }

}
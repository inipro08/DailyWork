package com.inis.famo.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.inis.famo.R
import com.inis.famo.data.model.ProductEntity
import com.inis.famo.databinding.ItemHomeTabProductBinding
import com.inis.famo.ui.base.BaseRecyclerViewAdapter
import com.inis.famo.utils.loadImageDrawable

class HomeProductAdapter(val context: Context,
                         val onItemClick: (ProductEntity) -> Unit,
                         val onFavoritesClick: (ProductEntity) -> Unit,
                         val onBuyClick: (ProductEntity) -> Unit) :
    BaseRecyclerViewAdapter<ProductEntity, ItemHomeTabProductBinding>(object :
        DiffUtil.ItemCallback<ProductEntity>() {
        override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem.product_id == newItem.product_id
        }

        override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem == newItem
        }
    }) {

    override val layoutRes: Int = R.layout.item_home_tab_product

    override fun bindData(itemBinding: ItemHomeTabProductBinding, position: Int) {
        super.bindData(itemBinding, position)
        val item = getItem(position)

        itemBinding.apply {
            ivTabProduct.loadImageDrawable(R.drawable.gao)
            tvTabProductName.text = item.product_name
            tvTabProductPrice.text = item.product_price
            tvTabProductUnit.text = item.product_unit
            ivTabFavorites.isSelected = item.product_isFavorites
            ivTabAddToCart.isSelected = item.product_isBuy
        }
        itemBinding.root.setOnClickListener { onItemClick(item) }
        itemBinding.ivTabFavorites.setOnClickListener{onFavoritesClick(item)}
        itemBinding.ivTabAddToCart.setOnClickListener{onBuyClick(item)}
    }

    override fun bindFirstTime(itemBinding: ItemHomeTabProductBinding) {
        itemBinding.run {

        }
    }
}
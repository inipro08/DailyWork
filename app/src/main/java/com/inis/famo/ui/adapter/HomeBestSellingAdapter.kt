package com.inis.famo.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.inis.famo.R
import com.inis.famo.data.model.BestSellingEntity
import com.inis.famo.databinding.ItemHomeHotBuyBinding
import com.inis.famo.ui.base.BaseRecyclerViewAdapter
import com.inis.famo.utils.loadImageDrawable

class HomeBestSellingAdapter(val context: Context, val onItemClick: (BestSellingEntity) -> Unit) :
    BaseRecyclerViewAdapter<BestSellingEntity, ItemHomeHotBuyBinding>(object :
        DiffUtil.ItemCallback<BestSellingEntity>() {
        override fun areItemsTheSame(oldItem: BestSellingEntity, newItem: BestSellingEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BestSellingEntity, newItem: BestSellingEntity): Boolean {
            return oldItem == newItem
        }
    }) {

    override val layoutRes: Int = R.layout.item_home_hot_buy

    override fun bindData(itemBinding: ItemHomeHotBuyBinding, position: Int) {
        super.bindData(itemBinding, position)
        itemBinding.apply {
//            ivProduct.load(pictureUrl = getItem(position)?.product_uri!!, RequestOptions())
            ivProduct.loadImageDrawable(R.drawable.gao)
            tvProductName.text = getItem(position)?.product_name
            tvProductPrice.text = getItem(position)?.product_price
            tvProductUnit.text= getItem(position).product_unit
        }
        itemBinding.root.setOnClickListener { onItemClick.invoke(getItem(position)) }
    }

    override fun bindFirstTime(itemBinding: ItemHomeHotBuyBinding) {
        itemBinding.run {

        }
    }
}
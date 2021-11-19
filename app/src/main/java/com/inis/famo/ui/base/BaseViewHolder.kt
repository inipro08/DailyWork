package com.inis.famo.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<ItemDataBinding : ViewDataBinding>(val itemBinding: ItemDataBinding) :
    RecyclerView.ViewHolder(itemBinding.root)
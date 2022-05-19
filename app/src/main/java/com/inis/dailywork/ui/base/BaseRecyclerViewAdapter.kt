package com.inis.dailywork.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.inis.dailywork.BR

abstract class BaseRecyclerViewAdapter<T, ItemDataBinding : ViewDataBinding>(itemCallback: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, BaseViewHolder<ItemDataBinding>>(itemCallback) {
    abstract val layoutRes: Int
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ItemDataBinding> =
        BaseViewHolder(createItemBinding(parent, viewType).apply {
            bindFirstTime(this)
        })

    open val itemVariable = BR.item
    open val isRecyclable = true

    open fun bindFirstTime(itemBinding: ItemDataBinding) {}

    open fun createItemBinding(parent: ViewGroup, viewType: Int): ItemDataBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutRes, parent, false
        )

    override fun submitList(list: List<T>?) {
        super.submitList(ArrayList<T>(list ?: listOf()))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ItemDataBinding>, position: Int) {
        holder.setIsRecyclable(isRecyclable)
        holder.apply {
            itemBinding.setVariable(itemVariable, getItem(position))
            bindData(itemBinding, position)
        }
    }

    open fun bindData(itemBinding: ItemDataBinding, position: Int) {

    }
}
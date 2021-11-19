package com.inis.famo.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.inis.famo.data.model.Application
import com.inis.famo.databinding.ItemLockedBinding
import com.inis.famo.ui.base.BaseRecyclerViewAdapter
import com.inis.famo.utils.setSingleClick

class HomeAdapter(
    val context: Context,
    val onBlockClick: (Application) -> Unit,
    val onTimerClick: (Application) -> Unit
) : BaseRecyclerViewAdapter<Application, ItemLockedBinding>(object :
    DiffUtil.ItemCallback<Application>() {
    override fun areItemsTheSame(oldItem: Application, newItem: Application): Boolean {
        return oldItem.packageName == newItem.packageName
    }

    override fun areContentsTheSame(oldItem: Application, newItem: Application): Boolean {
        return oldItem == newItem
    }
}) {
    override val layoutRes: Int = 0

    override fun bindData(itemBinding: ItemLockedBinding, position: Int) {
        super.bindData(itemBinding, position)
    }

    override fun bindFirstTime(itemBinding: ItemLockedBinding) {
        itemBinding.run {
            ivTimer.setSingleClick {
                onTimerClick(itemBinding.item ?: return@setSingleClick)
            }
            swBlock.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) onBlockClick(itemBinding.item ?: return@setOnCheckedChangeListener)
            }
        }
    }
}
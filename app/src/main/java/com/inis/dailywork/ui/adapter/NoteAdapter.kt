package com.inis.dailywork.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.inis.dailywork.R
import com.inis.dailywork.data.model.TodoItem
import com.inis.dailywork.databinding.ItemNoteBinding
import com.inis.dailywork.ui.base.BaseRecyclerViewAdapter

class NoteAdapter : BaseRecyclerViewAdapter<TodoItem, ItemNoteBinding>(object :
    DiffUtil.ItemCallback<TodoItem>() {
    override fun areItemsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: TodoItem, newItem: TodoItem): Boolean {
        return oldItem == newItem
    }
}) {
    override val layoutRes = R.layout.item_note

    override fun bindData(itemBinding: ItemNoteBinding, position: Int) {
        super.bindData(itemBinding, position)
    }
}
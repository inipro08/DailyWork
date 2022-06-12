package com.inis.dailywork.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.inis.dailywork.R
import com.inis.dailywork.data.model.NoteItem
import com.inis.dailywork.databinding.ItemNoteBinding
import com.inis.dailywork.ui.base.BaseRecyclerViewAdapter

class NoteAdapter : BaseRecyclerViewAdapter<NoteItem, ItemNoteBinding>(object :
    DiffUtil.ItemCallback<NoteItem>() {
    override fun areItemsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NoteItem, newItem: NoteItem): Boolean {
        return oldItem == newItem
    }
}) {
    override val layoutRes = R.layout.item_note

    override fun bindData(itemBinding: ItemNoteBinding, position: Int) {
        super.bindData(itemBinding, position)
    }
}
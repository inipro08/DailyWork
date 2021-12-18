package com.inis.famo.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.inis.famo.R
import com.inis.famo.data.model.ItemMoreEntity

class CustomItemMoreView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    private var containerRow: LinearLayout
    private var ivIcon: ImageView
    private var tvTitle: TextView
    private var ivArrow: ImageView

    init {
        inflate(context, R.layout.custom_item_more, this)
        containerRow = findViewById(R.id.containerRow)
        ivIcon = findViewById(R.id.ivIcon)
        tvTitle = findViewById(R.id.tvTitle)
        ivArrow = findViewById(R.id.ivArrow)
    }

    fun setData(listData: ArrayList<ItemMoreEntity>) {
        listData.forEach {
            ivIcon.setImageResource(it.icon)
            tvTitle.text = context.getString(it.title)
        }
    }
}
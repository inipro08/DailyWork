package com.inis.dailywork.data.model

import android.graphics.drawable.Drawable

data class Application(
    val name: String,
    val packageName: String,
    val icon: Drawable,
    var isLocked: Boolean = false
)
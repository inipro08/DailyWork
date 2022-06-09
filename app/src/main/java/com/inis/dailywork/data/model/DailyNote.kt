package com.inis.dailywork.data.model

import java.io.Serializable

data class NoteItem(
    val time: String = "",
    val title: String = "",
    val content: String = ""
) : Serializable
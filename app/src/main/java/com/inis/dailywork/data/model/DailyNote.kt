package com.inis.dailywork.data.model

import com.inis.dailywork.enum.NoteStatusType
import java.io.Serializable

data class NoteItem(
    val time: String = "",
    val title: String = "",
    val content: String = "",
    val noteStatusType: NoteStatusType? = NoteStatusType.CREATE
) : Serializable
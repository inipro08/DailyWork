package com.inis.dailywork.data.model

import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.inis.dailywork.enum.NoteStatusType
import com.inis.dailywork.utils.Constants
import kotlinx.android.parcel.Parcelize

@Entity(tableName = Constants.ENTITY_TO_DO_LIST)
@Parcelize
data class TodoItem(
    @SerializedName("time")
    val time: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("content")
    val content: String = "",
    @SerializedName("noteStatusType")
    val noteStatusType: NoteStatusType? = NoteStatusType.CREATE
) : Parcelable
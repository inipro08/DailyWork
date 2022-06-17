package com.inis.dailywork.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.inis.dailywork.enum.NoteStatusType
import com.inis.dailywork.utils.Constants
import kotlinx.android.parcel.Parcelize

@Entity(tableName = Constants.ENTITY_TO_DO_LIST)
@Parcelize
data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var time: String = "",
    var title: String = "",
    var content: String = "",
    var noteStatusType: NoteStatusType? = NoteStatusType.CREATE
) : Parcelable
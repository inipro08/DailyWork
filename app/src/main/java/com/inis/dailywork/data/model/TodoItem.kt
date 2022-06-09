package com.inis.dailywork.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class TodoItemEntity(
    @PrimaryKey(autoGenerate = true)
    val taskId: Long = 0L,
    @ColumnInfo(name = "task_name")
    val name: String = ""
) : Serializable

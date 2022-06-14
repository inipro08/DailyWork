package com.inis.dailywork.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.inis.dailywork.data.model.TodoItem

@Database(entities = [TodoItem::class], version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): AppDao
}

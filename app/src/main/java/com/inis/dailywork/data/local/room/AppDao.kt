package com.inis.dailywork.data.local.room

import androidx.room.*
import com.inis.dailywork.data.model.TodoItem
import io.reactivex.Observable

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(track: TodoItem)

    @Delete
    fun delete(track: TodoItem)

    @Query("SELECT * FROM todo")
    fun getAllFavorites(): Observable<List<TodoItem>>
}

package com.inis.dailywork.data.local.room

import androidx.room.*
import io.reactivex.Observable

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(track: Track)

    @Delete
    fun delete(track: Track)

    @Query("SELECT * FROM tracks")
    fun getAllFavorites(): Observable<List<Track>>
}

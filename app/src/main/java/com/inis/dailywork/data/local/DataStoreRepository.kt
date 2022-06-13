package com.inis.dailywork.data.local

import com.inis.dailywork.data.local.dataStore.DataStoreHelper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreRepository @Inject constructor(private val dataStore: DataStoreHelper) {

    suspend fun setTheme(theme: Int) {
        dataStore.setTheme(theme)
    }

    fun getTheme(): Flow<Int> = dataStore.theme
}
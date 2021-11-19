package com.inis.famo.data.repository

import com.inis.famo.data.model.Application
import io.reactivex.Completable
import io.reactivex.Single

interface AppRepository {
    fun getAllAppInstalled(): Single<List<Application>>

    fun setApLocker(packageName: String, isLock: Boolean): Completable

    fun getAppLocker(packageName: String): Boolean
}

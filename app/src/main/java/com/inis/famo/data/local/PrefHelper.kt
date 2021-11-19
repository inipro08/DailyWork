package com.inis.famo.data.local

import io.reactivex.Completable

interface PrefHelper {
    fun setAppLocker(packageName: String,isLock:Boolean): Completable
    fun getAppLocker(packageName: String): Boolean
}
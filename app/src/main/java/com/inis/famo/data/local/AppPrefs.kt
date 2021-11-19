package com.inis.famo.data.local

import android.content.Context
import io.reactivex.Completable
import javax.inject.Inject

class AppPrefs @Inject constructor(val context: Context) : PrefHelper {
    companion object {
        const val PREF_PREFIX_LOCKER = "locker_"
    }

    private var sharedPreferences =
        context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    override fun setAppLocker(packageName: String, isLock: Boolean): Completable {
        return Completable.fromAction {
            sharedPreferences.edit().putBoolean(PREF_PREFIX_LOCKER + packageName, isLock).apply()
        }
    }

    override fun getAppLocker(packageName: String): Boolean {
        return sharedPreferences.getBoolean(PREF_PREFIX_LOCKER + packageName, false)
    }

}
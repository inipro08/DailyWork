package com.inis.famo.data.local

import android.content.Context
import io.reactivex.Completable
import javax.inject.Inject

class AppPrefs @Inject constructor(val context: Context) : PrefHelper {
    companion object {
        const val PREF_PREFIX_LOCKER = "famo_"
    }

    private var sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

}
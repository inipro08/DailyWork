package com.inis.famo.data.repository

import android.content.Context
import android.content.Intent
import com.inis.famo.data.local.PrefHelper
import com.inis.famo.data.model.Application
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(val context: Context, val prefHelper: PrefHelper) :
    AppRepository {
    override fun getAllAppInstalled(): Single<List<Application>> {
        return Single.fromCallable {
            val mainIntent = Intent(Intent.ACTION_MAIN)
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
            context.packageManager.queryIntentActivities(mainIntent, 0)
        }.map {
            it.map {
                Application(
                    name = context.packageManager.getApplicationLabel(it.activityInfo.applicationInfo)
                        .toString(),
                    packageName = it.activityInfo.packageName,
                    icon = context.packageManager.getApplicationIcon(it.activityInfo.applicationInfo)
                )
            }
        }
    }

    override fun setApLocker(packageName: String, isLock: Boolean): Completable {
        return prefHelper.setAppLocker(packageName, isLock)
    }

    override fun getAppLocker(packageName: String): Boolean {
        return prefHelper.getAppLocker(packageName)
    }
}
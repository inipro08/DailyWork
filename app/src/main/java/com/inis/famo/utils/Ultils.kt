package com.inis.famo.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import com.inis.famo.BuildConfig
import com.inis.famo.R

fun Context?.shareApp(onFailed: () -> Unit) {
    if (this == null) {
        onFailed()
        return
    }
    val intent = Intent().apply {
        action = Intent.ACTION_SEND
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        putExtra(
            Intent.EXTRA_TEXT,
            this@shareApp.resources.getString(R.string.message_share_app, BuildConfig.SHARE_APP_URL)
        )
        type = "text/plain"
    }
    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        onFailed()
    }
}

package com.inis.famo.utils

import android.content.Context
import android.graphics.Color
import android.os.SystemClock
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.inis.famo.R

fun View.setSingleClick(timeout: Long = 1000L, execution: () -> Unit) {
    setOnClickListener(object : View.OnClickListener {
        var lastClickTime: Long = 0
        override fun onClick(p0: View?) {
            if (SystemClock.elapsedRealtime() - lastClickTime < timeout) {
                return
            }
            lastClickTime = SystemClock.elapsedRealtime()
            execution.invoke()
        }
    })
}

fun View.showSnackMessage(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}

fun View.showSnackMessage(message: String, action: String, callbackAction: () -> Unit) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .setAction(action) {
            callbackAction()
        }
        .show()
}

fun Fragment.showSnackBar(
    onClick: (() -> Unit)? = null,
    layout: View,
    resourceIdMessage: Int,
    resourceIdActionTitle: Int = R.string.message_empty,
    actionTextColor: Int = Color.WHITE,
    duration: Int = Snackbar.LENGTH_SHORT
) {
    Snackbar.make(layout, resourceIdMessage, duration).setAction(getString(resourceIdActionTitle)) {
        onClick?.invoke()
    }
        .setActionTextColor(actionTextColor)
        .show()
}

fun View.hideKeyBoard() {
    val inputMethodManager =
        context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_IMPLICIT_ONLY)
}

package com.inis.dailywork.utils

import android.content.Context
import android.os.SystemClock
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.NumberPicker
import androidx.viewpager.widget.ViewPager

fun View.goneWhenNull(value: Any?) {
    this.visibleWhenTrue(value != null)
}

fun View.visibleWhenTrue(value: Boolean) {
    this.visibility = if (value) View.VISIBLE else View.GONE
}

fun View.goneWhenTrue(value: Boolean) {
    this.visibility = if (value) View.GONE else View.VISIBLE
}

fun View.invisibleWhenTrue(value: Boolean) {
    this.visibility = if (value) View.INVISIBLE else View.VISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.setOnSafeClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener { onSafeClick(it) }
    setOnClickListener(safeClickListener)
}

class SafeClickListener(private val onSafeCLick: (View) -> Unit) : View.OnClickListener {
    companion object {
        var lastTimeClicked: Long = 0
    }

    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < Constants.DEFAULT_INTERVAL) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeCLick(v)
    }
}

fun ViewPager.onPageSelected(callback: (Int) -> Unit) {
    this.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            callback(position)
        }

        override fun onPageScrollStateChanged(state: Int) {
        }
    })
}

fun EditText.inputListener(afterTextChanged: ((String) -> Unit?)? = null) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(
            charSequence: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            afterTextChanged?.invoke(s.toString().trim())
        }
    })
}

fun NumberPicker.onValueChange(onValueChanged: (Int) -> Unit) {
    this.setOnValueChangedListener { picker, oldVal, newVal -> onValueChanged(newVal) }
}

fun View.showKeyboard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    requestFocus()
    inputMethodManager.showSoftInput(this.findFocus(), InputMethodManager.SHOW_IMPLICIT)
}

fun View.hideKeyboard() {
    val inputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    clearFocus()
    inputMethodManager.showSoftInput(this.findFocus(), InputMethodManager.HIDE_IMPLICIT_ONLY)
}

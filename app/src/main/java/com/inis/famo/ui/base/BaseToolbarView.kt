package com.inis.famo.ui.base

import android.view.View

abstract class BaseToolbarView<O, C> protected constructor(protected val observer: O, protected val binding: C) {

    open fun initialize(view: View) {

    }
}

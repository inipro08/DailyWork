package com.inis.famo.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.inis.famo.R
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity(@LayoutRes val layoutRes: Int) : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }

    protected fun addFragment(fragment: Fragment, tag: String, isAddBackStack: Boolean = false) {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container_main_activity, fragment, tag)
            if (isAddBackStack) addToBackStack(null)
            commit()
        }
    }

    protected fun replaceFragment(fragment: Fragment, isAddBackStack: Boolean = false) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_main_activity, fragment, fragment.tag)
            if (isAddBackStack) addToBackStack(null)
            commit()
        }
    }
}

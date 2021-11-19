package com.inis.famo.ui.screen.activity.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.inis.famo.R
import com.inis.famo.ui.base.BaseActivity
import com.inis.famo.ui.screen.activity.intro.IntroActivity
import com.inis.famo.ui.screen.fragment.home.HomeFragment

class MainActivity : BaseActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment(HomeFragment.newInstance(), tag = HomeFragment.TAG, false)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    companion object {
        @JvmStatic
        fun intent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
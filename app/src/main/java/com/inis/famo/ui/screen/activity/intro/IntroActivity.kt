package com.inis.famo.ui.screen.activity.intro

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import com.inis.famo.R
import com.inis.famo.ui.base.BaseActivity
import com.inis.famo.ui.screen.activity.main.MainActivity

class IntroActivity : BaseActivity(R.layout.activity_intro) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<ImageView>(R.id.ivNextIntro).setOnClickListener {
            nextHomeScreen()
        }
    }

    private fun nextHomeScreen() {
        startActivity(MainActivity.intent(context = this))
        finish()
    }

    override fun onBackPressed() {

    }

    companion object {
        @JvmStatic
        fun intent(context: Context): Intent {
            return Intent(context, IntroActivity::class.java)
        }
    }
}
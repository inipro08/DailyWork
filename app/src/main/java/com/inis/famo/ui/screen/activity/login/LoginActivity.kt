package com.inis.famo.ui.screen.activity.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.inis.famo.R
import com.inis.famo.ui.base.BaseActivity
import com.inis.famo.ui.screen.activity.intro.IntroActivity

class LoginActivity : BaseActivity(R.layout.activity_login) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onBackPressed() {

    }

    companion object {
        @JvmStatic
        fun intent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
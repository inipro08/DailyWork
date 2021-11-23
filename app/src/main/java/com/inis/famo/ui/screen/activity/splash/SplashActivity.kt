package com.inis.famo.ui.screen.activity.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.inis.famo.R
import com.inis.famo.databinding.ActivitySplashBinding
import com.inis.famo.ui.base.BaseActivity
import com.inis.famo.ui.screen.activity.intro.IntroActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity : BaseActivity<ActivitySplashBinding,SplashViewModel>(R.layout.activity_splash) {

    override fun onBackPressed() {}

    companion object {
        @JvmStatic
        fun intent(context: Context): Intent {
            val intent = Intent(context, SplashActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP
            return intent
        }
    }

    override fun viewModelClass() = SplashViewModel::class.java

    override fun ActivitySplashBinding.initView() {
        Timer("SHOW INTRO", false).schedule(1500) {
            startActivity(IntroActivity.intent(context = applicationContext))
            finish()
        }
    }

    override fun ActivitySplashBinding.addEvent() {

    }

    override fun SplashViewModel.observeLiveData() {
    }
}
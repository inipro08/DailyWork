package com.inis.famo.ui.screen.activity.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.inis.famo.R
import com.inis.famo.databinding.ActivityLoginBinding
import com.inis.famo.ui.base.BaseActivity
import com.inis.famo.ui.screen.activity.intro.IntroActivity

class LoginActivity : BaseActivity<ActivityLoginBinding,LoginViewModel>(R.layout.activity_login) {

    companion object {
        @JvmStatic
        fun intent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun viewModelClass(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    override fun ActivityLoginBinding.addEvent() {

    }

    override fun ActivityLoginBinding.initView() {
    }

    override fun LoginViewModel.observeLiveData() {
    }
}
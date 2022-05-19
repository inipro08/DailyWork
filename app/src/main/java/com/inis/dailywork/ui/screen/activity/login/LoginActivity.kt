package com.inis.dailywork.ui.screen.activity.login

import android.content.Context
import android.content.Intent
import com.inis.dailywork.R
import com.inis.dailywork.databinding.ActivityLoginBinding
import com.inis.dailywork.ui.base.BaseActivity

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
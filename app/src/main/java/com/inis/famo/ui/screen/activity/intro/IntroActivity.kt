package com.inis.famo.ui.screen.activity.intro

import android.content.Context
import android.content.Intent
import com.inis.famo.R
import com.inis.famo.databinding.ActivityIntroBinding
import com.inis.famo.ui.base.BaseActivity
import com.inis.famo.ui.screen.activity.main.MainActivity
import top.wefor.circularanim.CircularAnim

class IntroActivity : BaseActivity<ActivityIntroBinding, IntroViewModel>(R.layout.activity_intro) {

    companion object {
        @JvmStatic
        fun intent(context: Context): Intent {
            return Intent(context, IntroActivity::class.java)
        }
    }

    override fun viewModelClass() = IntroViewModel::class.java

    override fun ActivityIntroBinding.initView() {

    }

    override fun ActivityIntroBinding.addEvent() {
       ivNextIntro.setOnClickListener {
           CircularAnim.fullActivity(this@IntroActivity,ivNextIntro)
               .colorOrImageRes(R.color.color_general)
               .duration(350)
               .go { nextHomeScreen() }
       }
    }

    override fun IntroViewModel.observeLiveData() {
    }

    private fun nextHomeScreen() {
        startActivity(MainActivity.intent(context = this))
        finish()
    }
}
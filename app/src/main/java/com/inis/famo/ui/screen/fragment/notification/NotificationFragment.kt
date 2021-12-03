package com.inis.famo.ui.screen.fragment.notification

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import com.inis.famo.R
import com.inis.famo.databinding.NotifyBinding
import com.inis.famo.ui.base.BaseFragment
import com.inis.famo.ui.screen.fragment.more.MoreViewModel

class NotificationFragment :
    BaseFragment<NotifyBinding, NotificationViewModel>(R.layout.fragment_notify) {
    companion object {
        const val TAG = "NotificationFragment"
        fun newInstance() = NotificationFragment()
    }

    override fun viewModelClass() = NotificationViewModel::class.java

    @SuppressLint("CheckResult")
    override fun NotifyBinding.initComponents() {

    }

    @SuppressLint("StringFormatMatches")
    override fun NotificationViewModel.observeLiveData() {

    }

    override fun NotifyBinding.addEvent() {

    }
}
package com.inis.famo.ui.screen.fragment.more

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import com.inis.famo.R
import com.inis.famo.databinding.MoreBinding
import com.inis.famo.ui.base.BaseFragment
import com.inis.famo.ui.screen.fragment.home.HomeViewModel

class MoreFragment : BaseFragment<MoreBinding, MoreViewModel>(R.layout.fragment_more) {

    companion object {
        const val TAG = "MoreFragment"
        fun newInstance() = MoreFragment()
    }

    override fun viewModelClass() = MoreViewModel::class.java

    @SuppressLint("CheckResult")
    override fun MoreBinding.initComponents() {

    }

    @SuppressLint("StringFormatMatches")
    override fun MoreViewModel.observeLiveData() {

    }

    override fun MoreBinding.addEvent() {

    }
}
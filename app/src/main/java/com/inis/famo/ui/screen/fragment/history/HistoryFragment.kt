package com.inis.famo.ui.screen.fragment.history

import android.annotation.SuppressLint
import com.inis.famo.R
import com.inis.famo.databinding.HistoryBinding
import com.inis.famo.ui.base.BaseFragment

class HistoryFragment : BaseFragment<HistoryBinding, HistoryViewModel>(R.layout.fragment_history) {

    companion object {
        const val TAG = "HistoryFragment"
        fun newInstance() = HistoryFragment()
    }

    override fun viewModelClass() = HistoryViewModel::class.java

    @SuppressLint("CheckResult")
    override fun HistoryBinding.initComponents() {

    }

    @SuppressLint("StringFormatMatches")
    override fun HistoryViewModel.observeLiveData() {

    }

    override fun HistoryBinding.addEvent() {

    }
}
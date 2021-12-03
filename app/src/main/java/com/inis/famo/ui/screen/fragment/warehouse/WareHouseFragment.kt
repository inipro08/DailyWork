package com.inis.famo.ui.screen.fragment.warehouse

import android.annotation.SuppressLint
import com.inis.famo.R
import com.inis.famo.databinding.WareHouseBinding
import com.inis.famo.ui.base.BaseFragment

class WareHouseFragment :
    BaseFragment<WareHouseBinding, WareHouseViewModel>(R.layout.fragment_warehouse) {
    companion object {
        const val TAG = "WareHouseFragment"
        fun newInstance() = WareHouseFragment()
    }

    override fun viewModelClass() = WareHouseViewModel::class.java


    @SuppressLint("CheckResult")
    override fun WareHouseBinding.initComponents() {

    }

    @SuppressLint("StringFormatMatches")
    override fun WareHouseViewModel.observeLiveData() {

    }

    override fun WareHouseBinding.addEvent() {

    }
}
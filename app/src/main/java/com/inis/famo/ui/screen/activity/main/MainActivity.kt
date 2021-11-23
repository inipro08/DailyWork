package com.inis.famo.ui.screen.activity.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.inis.famo.R
import com.inis.famo.databinding.ActivityMainBinding
import com.inis.famo.ui.base.BaseActivity
import com.inis.famo.ui.screen.fragment.history.HistoryFragment
import com.inis.famo.ui.screen.fragment.home.HomeFragment
import com.inis.famo.ui.screen.fragment.more.MoreFragment
import com.inis.famo.ui.screen.fragment.warehouse.WareHouseFragment
import kotlinx.android.synthetic.main.activity_main.*
import top.wefor.circularanim.CircularAnim

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(R.layout.activity_main) {
    private var homeFragment: HomeFragment? = null
    private var wareHouseFragment: WareHouseFragment? = null
    private var historyFragment: HistoryFragment? = null
    private var moreFragment: MoreFragment? = null

    private val TAB_HOME_TAG = "TAB_HOME"
    private val TAB_WARE_HOUSE_TAG = "TAB_WARE_HOUSE"
    private val TAB_HISTORY_TAG = "TAB_HISTORY"
    private val TAB_MORE_TAG = "TAB_MORE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigation.setOnNavigationItemSelectedListener { menu ->
            onTabMenuSelected(menu = menu)
        }
        navigation.selectedItemId = R.id.tab_home
    }

    private fun onTabMenuSelected(menu: MenuItem): Boolean {
        return when (menu.itemId) {
            R.id.tab_home -> {
                openHomeFragment()
            }
            R.id.tab_warehouse -> {
                openWareHouseFragment()
            }
            R.id.tab_history -> {
                openHistoryFragment()
            }
            R.id.tab_more -> {
                openMoreFragment()
            }
            else -> false
        }
    }

    private fun openHomeFragment(): Boolean {
        if (homeFragment == null) homeFragment = HomeFragment()
        return replaceFragment(HomeFragment(), false)
    }

    private fun openWareHouseFragment(): Boolean {
        if (wareHouseFragment == null) wareHouseFragment = WareHouseFragment()
        return replaceFragment(WareHouseFragment(), false)
    }

    private fun openHistoryFragment(): Boolean {
        if (historyFragment == null) historyFragment = HistoryFragment()
        return replaceFragment(HistoryFragment(), false)
    }

    private fun openMoreFragment(): Boolean {
        if (moreFragment == null) moreFragment = MoreFragment()
        return replaceFragment(MoreFragment(), false)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    companion object {
        @JvmStatic
        fun intent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun viewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun ActivityMainBinding.addEvent() {
    }

    override fun ActivityMainBinding.initView() {
    }

    override fun MainViewModel.observeLiveData() {
    }
}
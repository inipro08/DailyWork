package com.inis.famo.ui.screen.activity.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.inis.famo.R
import com.inis.famo.databinding.ActivityMainBinding
import com.inis.famo.ui.adapter.HomePagerAdapter
import com.inis.famo.ui.adapter.MainPagerAdapter
import com.inis.famo.ui.base.BaseActivity
import com.inis.famo.ui.screen.activity.intro.IntroActivity
import com.inis.famo.ui.screen.fragment.history.HistoryFragment
import com.inis.famo.ui.screen.fragment.home.HomeFragment
import com.inis.famo.ui.screen.fragment.more.MoreFragment
import com.inis.famo.ui.screen.fragment.warehouse.WareHouseFragment
import com.inis.famo.utils.onPageSelected
import kotlinx.android.synthetic.main.activity_main.*
import top.wefor.circularanim.CircularAnim
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(R.layout.activity_main) {

   /* private var homeFragment: HomeFragment? = null
    private var wareHouseFragment: WareHouseFragment? = null
    private var historyFragment: HistoryFragment? = null
    private var moreFragment: MoreFragment? = null*/

    private var mainPagerAdapter : MainPagerAdapter? = null
    private var currentItem = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigation.setOnNavigationItemSelectedListener { menu ->
            onTabMenuSelected(menu = menu)
        }
        navigation.selectedItemId = R.id.tab_home
    }

    private fun onTabMenuSelected(menu: MenuItem): Boolean {
         when (menu.itemId) {
            R.id.tab_home -> {
               mainViewPaper.currentItem = 0
            }
            R.id.tab_warehouse -> {
                mainViewPaper.currentItem = 1
            }
            R.id.tab_history -> {
                mainViewPaper.currentItem = 2
            }
            R.id.tab_more -> {
                mainViewPaper.currentItem = 3
            }
        }

        return true
    }

    /*private fun openHomeFragment(): Boolean {
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
    }*/

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
        val listFragment = arrayListOf(HomeFragment(),WareHouseFragment(),HistoryFragment(),MoreFragment())

        mainPagerAdapter = MainPagerAdapter(
            fragmentManager = supportFragmentManager,
            listFragment = listFragment
        )

        mainViewPaper.adapter = mainPagerAdapter
        mainViewPaper.onPageSelected {
            currentItem = it
        }
        mainViewPaper.offscreenPageLimit = listFragment.size

        swipeContainer.setOnRefreshListener {
            Timer("SHOW INTRO", false).schedule(1500) {
                showLoading(isLoad = false)
            }
        }
    }

    override fun MainViewModel.observeLiveData() {
    }

    private fun showLoading(isLoad : Boolean){
        binding.swipeContainer.isRefreshing = isLoad
    }
}
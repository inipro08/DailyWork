package com.inis.famo.ui.screen.fragment.home

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.util.Log
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import com.inis.famo.R
import com.inis.famo.data.model.Application
import com.inis.famo.databinding.MainBinding
import com.inis.famo.ui.adapter.HomeAdapter
import com.inis.famo.ui.base.BaseFragment
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class HomeFragment :
    BaseFragment<MainBinding, HomeViewModel>(R.layout.fragment_main) {
    companion object {
        const val TAG = "AppLockerFragment"
        fun newInstance() = HomeFragment()
    }

    private var homeAdapter: HomeAdapter? = null

    override val viewModel: HomeViewModel
        get() = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]

    @SuppressLint("CheckResult")
    override fun MainBinding.initComponents() {
        Observable.interval(1000, TimeUnit.MILLISECONDS)
            .map {
                val activityManager =
                    context?.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
                val taskInfo = activityManager.runningAppProcesses
                taskInfo.forEach {
                    Log.d(TAG, "initComponents: ${it.pkgList[0]}")
                }
            }
            .subscribe({

            }, {})

        getData()
        initAppRecyclerView()
    }

    private fun initAppRecyclerView() {
        homeAdapter =
            HomeAdapter(context = requireContext(), ::onTimerApplication, ::onLockApplication)
    }

    @SuppressLint("StringFormatMatches")
    override fun observeLiveData() {
        with(viewModel) {

        }
    }

    private fun getData() {
        with(viewModel) {

        }
    }

    override fun MainBinding.addEvent() {
        with(binding) {

        }
    }

    private fun onTimerApplication(application: Application) {

    }

    private fun onLockApplication(application: Application) {

    }
}
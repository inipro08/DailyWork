package com.inis.dailywork.ui.screen.activity.main

import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.inis.dailywork.R
import com.inis.dailywork.databinding.ActivityMainBinding
import com.inis.dailywork.ui.base.BaseActivity
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.HorizontalCalendarView
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import java.util.*


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    val TAG = "MainActivity"

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

        /* starts before 1 month from now */
        val startDate: Calendar = Calendar.getInstance()
        startDate.add(Calendar.YEAR, -1)

        /* ends after 1 month from now */
        val endDate = Calendar.getInstance()
        endDate.add(Calendar.YEAR, 1)

        val horizontalCalendar: HorizontalCalendar =
            HorizontalCalendar.Builder(this@MainActivity, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build()

        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onDateSelected(date: Calendar?, position: Int) {
                Log.d(TAG, "onDateSelected: ${date?.time?.toInstant().toString()}")
            }
            override fun onCalendarScroll(
                calendarView: HorizontalCalendarView,
                dx: Int, dy: Int
            ) {
            }

            override fun onDateLongClicked(date: Calendar?, position: Int): Boolean {
                return true
            }
        }

    }

    override fun MainViewModel.observeLiveData() {
    }
}
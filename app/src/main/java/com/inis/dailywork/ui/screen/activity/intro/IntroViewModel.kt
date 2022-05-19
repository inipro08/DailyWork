package com.inis.dailywork.ui.screen.activity.intro

import androidx.lifecycle.MutableLiveData
import com.inis.dailywork.ui.base.BaseViewModel
import javax.inject.Inject

class IntroViewModel @Inject constructor() : BaseViewModel() {

    val isFirst = MutableLiveData<Int>()
}
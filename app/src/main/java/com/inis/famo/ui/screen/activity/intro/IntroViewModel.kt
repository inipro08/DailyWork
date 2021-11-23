package com.inis.famo.ui.screen.activity.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.inis.famo.ui.base.BaseViewModel
import javax.inject.Inject

class IntroViewModel @Inject constructor() : BaseViewModel() {

    val isFirst = MutableLiveData<Int>()
}
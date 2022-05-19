package com.inis.dailywork.ui.base

import androidx.lifecycle.ViewModel
import com.inis.dailywork.data.repository.AppRepository
import com.inis.dailywork.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    fun onActivityDestroyed() {
        compositeDisposable.clear()
    }

    @Inject
    protected lateinit var apiRepository: AppRepository

    val viewState = SingleLiveEvent<Int>()
    protected val disposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}

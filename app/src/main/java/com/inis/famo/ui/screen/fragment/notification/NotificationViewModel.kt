package com.inis.famo.ui.screen.fragment.notification

import com.inis.famo.data.repository.AppRepository
import com.inis.famo.rx.SchedulerProvider
import com.inis.famo.ui.base.BaseViewModel
import javax.inject.Inject

class NotificationViewModel @Inject constructor(
    private val appRepository: AppRepository,
    private val schedulerProvider: SchedulerProvider
) : BaseViewModel() {

}
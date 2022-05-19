package com.inis.dailywork.data.repository

import android.content.Context
import com.inis.dailywork.data.local.PrefHelper
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(val context: Context, val prefHelper: PrefHelper) : AppRepository {
}
package com.inis.famo.data.repository

import android.content.Context
import android.content.Intent
import com.inis.famo.data.local.PrefHelper
import com.inis.famo.data.model.Application
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(val context: Context, val prefHelper: PrefHelper) : AppRepository {
}
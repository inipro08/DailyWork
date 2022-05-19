package com.inis.dailywork.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LazySearch(private val callback: (search: String) -> Unit) {
    private var debouncePeriod: Long = 500
    private var searchJob: Job? = null
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    fun search(newText: String) {
        searchJob?.cancel()
        searchJob = coroutineScope.launch {
            delay(debouncePeriod)
            callback(newText)
        }
    }
}

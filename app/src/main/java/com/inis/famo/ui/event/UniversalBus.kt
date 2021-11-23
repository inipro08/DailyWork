package com.inis.famo.ui.event

import org.greenrobot.eventbus.EventBus

object UniversalBus {
    private val bus = EventBus()
    fun register(subscriber: Any?) {
        Bus.register(subscriber, bus)
    }

    fun unregister(subscriber: Any?) {
        Bus.unregister(subscriber, bus)
    }

    fun post(event: Any?) {
        bus.post(event)
    }
}

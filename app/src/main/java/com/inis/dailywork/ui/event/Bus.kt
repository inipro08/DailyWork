package com.inis.dailywork.ui.event

import org.greenrobot.eventbus.EventBus
import java.lang.Exception

class Bus {
    companion object{
        private fun Bus() {}

        fun register(subscriber: Any?, bus: EventBus) {
            try {
                if (!bus.isRegistered(subscriber)) {
                    bus.register(subscriber)
                }
            } catch (e: Exception) {
                // ignore
            }
        }

        fun unregister(subscriber: Any?, bus: EventBus) {
            try {
                if (bus.isRegistered(subscriber)) {
                    bus.unregister(subscriber)
                }
            } catch (e: Exception) {
                // ignore
            }
        }
    }
}
package com.inis.dailywork.ui.base

class BaseEvent {
    override fun toString(): String {
        val builder = StringBuilder()

        for (field in javaClass.fields) {
            try {
                if (builder.isNotEmpty()) {
                    builder.append(", ")
                }
                builder.append(field.name)
                builder.append("=")
                builder.append(field[this])
            } catch (e: Exception) {
                // ignore
            }
        }

        return String.format(":[%s]", builder.toString())
    }
}
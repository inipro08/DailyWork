package com.inis.famo.data.model

import java.io.Serializable

data class NotificationEntity(
    val id: String = "",
    val noti_title: String = "",
    val noti_description: String = "",
    val noti_icon: Int = 0,
    val noti_createDate: String = "",
    val noti_isRead: Boolean = false
) : Serializable
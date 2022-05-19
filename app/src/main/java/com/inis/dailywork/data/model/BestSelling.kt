package com.inis.dailywork.data.model

import java.io.Serializable

data class BestSellingEntity(
    val id: Int = 0,
    val product_name: String = "",
    val product_uri: String = "",
    val product_price : String = "",
    val product_unit : String = "",
    val group_name: String = "",
    val rank: Int = 0,
) : Serializable
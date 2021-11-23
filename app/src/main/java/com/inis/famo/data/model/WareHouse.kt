package com.inis.famo.data.model

import java.io.Serializable

data class WareHouseEntity(
    val groupId: String = "",
    val groupName: String = "",
    val listProduct: ArrayList<ProductEntity> = arrayListOf()
) : Serializable
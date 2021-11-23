package com.inis.famo.data.model

import java.io.Serializable

data class TabProduct(
    val groupName : String = "",
    val listProduct : ArrayList<ProductEntity> = arrayListOf()
) : Serializable

data class ProductEntity(
    val product_id: String = "",
    val product_name: String = "",
    val product_url: String = "",
    val product_price: String = "",
    val product_unit: String = "",
    val groupName: String = "",
    val product_isFavorites: Boolean = false,
    val product_isBuy: Boolean = false
) : Serializable

data class ProductDetailEntity(
    val product_id: String = "",
    val product_name: String = "",
    val product_description: String = "",
    val product_url: String = "",
    val product_price: String = "",
    val product_value: String = "",
    val product_unit: String = "",
    val product_isFavorites: Boolean = false,
    val product_isBuy: Boolean = false
) : Serializable

data class AddNewProductEntity(
    val product_id: String = "",
    val product_name: String = "",
    val product_url: String = "",
    val groupName: String = "",
    val product_quantity: Int = 0,
    val product_unit: String = ""
) : Serializable
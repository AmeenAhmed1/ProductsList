package com.ameen.productlist.domain.model

data class ProductModel(
    val productTitle: String,
    val productDescription: String,
    val productPrice: String,
    val productImages: List<String>
)

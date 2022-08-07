package com.ameen.productlist.data.mapper

import com.ameen.productlist.data.remote.model.Product
import com.ameen.productlist.domain.model.ProductModel

fun Product.toDomainLayer() =
    ProductModel(
        productId = this.id,
        productTitle = this.title,
        productDescription = this.description,
        productImages = this.images,
        productPrice = "${this.price} EG"
    )
package com.ameen.productlist.presentation.listener

import com.ameen.productlist.domain.model.ProductModel

interface ProductItemClickListener {
    fun onProductItemClicked(selectedProduct: ProductModel)
}
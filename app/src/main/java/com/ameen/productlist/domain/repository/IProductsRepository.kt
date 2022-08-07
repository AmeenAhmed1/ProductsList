package com.ameen.productlist.domain.repository

import com.ameen.productlist.core.wrapper.ResultWrapper
import com.ameen.productlist.domain.model.ProductModel
import kotlinx.coroutines.flow.Flow

interface IProductsRepository {
    fun getAllProducts(): Flow<ResultWrapper<List<ProductModel>>>
}
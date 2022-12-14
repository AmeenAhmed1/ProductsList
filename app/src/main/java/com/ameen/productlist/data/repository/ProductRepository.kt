package com.ameen.productlist.data.repository

import com.ameen.productlist.core.wrapper.ResultWrapper
import com.ameen.productlist.data.mapper.toDomainLayer
import com.ameen.productlist.data.remote.ProductsApi
import com.ameen.productlist.domain.model.ProductModel
import com.ameen.productlist.domain.repository.IProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepository @Inject constructor(val api: ProductsApi) : IProductsRepository {

    override fun getAllProducts(): Flow<ResultWrapper<List<ProductModel>>> {
        return flow {
            try {
                val response = api.getAllProducts()
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(
                            ResultWrapper.Success(
                                it.products.map { it.toDomainLayer() }
                            )
                        )
                    } ?: emit(ResultWrapper.Error("Something Happen Please Try Again!!"))
                } else {
                    emit(ResultWrapper.Error(response.errorBody().toString()))
                }
            } catch (e: Exception) {
                emit(ResultWrapper.Error(e.message.toString()))
            }
        }
    }
}
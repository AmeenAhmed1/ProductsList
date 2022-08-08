package com.ameen.productlist.domain.usecase

import com.ameen.productlist.core.wrapper.ResultWrapper
import com.ameen.productlist.domain.model.ProductModel
import com.ameen.productlist.domain.repository.IProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(val repo: IProductsRepository) {
    fun execute(): Flow<ResultWrapper<List<ProductModel>>> {
        return repo.getAllProducts()
    }
}
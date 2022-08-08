package com.ameen.productlist.presentation.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ameen.productlist.core.wrapper.ResultWrapper
import com.ameen.productlist.domain.model.ProductModel
import com.ameen.productlist.domain.usecase.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

    private val _productsData: MutableStateFlow<ResultWrapper<List<ProductModel>>> =
        MutableStateFlow(ResultWrapper.Loading)
    val productsData = _productsData

    init {
        getAllProducts()
    }

    fun getAllProducts() =
        getAllProductsUseCase.execute()
            .flowOn(Dispatchers.IO)
            .onEach {
                _productsData.emit(it)
            }.launchIn(viewModelScope)
}
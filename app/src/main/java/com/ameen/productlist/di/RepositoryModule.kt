package com.ameen.productlist.di

import com.ameen.productlist.data.remote.ProductsApi
import com.ameen.productlist.data.repository.LoginRepository
import com.ameen.productlist.data.repository.ProductRepository
import com.ameen.productlist.domain.repository.ILoginRepository
import com.ameen.productlist.domain.repository.IProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesProductsRepository(api: ProductsApi) =
        ProductRepository(api) as IProductsRepository

    @Singleton
    @Provides
    fun providesLoginRepository() =
        LoginRepository() as ILoginRepository

}
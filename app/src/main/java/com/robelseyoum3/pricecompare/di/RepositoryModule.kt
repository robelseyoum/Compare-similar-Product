package com.robelseyoum3.pricecompare.di

import com.robelseyoum3.pricecompare.repository.GetProductRepositoryImpl
import com.robelseyoum3.pricecompare.viewmodel.ProductViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideViewModelFactory(getProductRepositoryImpl: GetProductRepositoryImpl): ProductViewModelFactory{
        return ProductViewModelFactory(getProductRepositoryImpl)
    }
}
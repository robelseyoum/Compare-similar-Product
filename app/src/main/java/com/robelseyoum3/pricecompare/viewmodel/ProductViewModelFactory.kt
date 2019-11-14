package com.robelseyoum3.pricecompare.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.robelseyoum3.pricecompare.repository.GetProductRepositoryImpl


@Suppress("UNCHECKED_CAST")
class ProductViewModelFactory(private val getProductRepositoryImpl: GetProductRepositoryImpl): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(getProductRepositoryImpl) as T
    }

}
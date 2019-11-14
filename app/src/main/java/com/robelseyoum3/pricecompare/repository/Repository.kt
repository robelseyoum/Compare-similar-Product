package com.robelseyoum3.pricecompare.repository

import com.robelseyoum3.pricecompare.model.Product
import io.reactivex.Single

interface Repository {
    fun getProductRepositoryMethod(): Single<List<Product>>
}
package com.robelseyoum3.pricecompare.network

import com.robelseyoum3.pricecompare.model.Product
import io.reactivex.Single
import retrofit2.http.GET

interface WebServices {

    @GET("9asku/")
    fun fetchProductWebService(): Single<List<Product>>
}
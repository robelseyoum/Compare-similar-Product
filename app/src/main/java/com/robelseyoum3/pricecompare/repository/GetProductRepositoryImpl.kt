package com.robelseyoum3.pricecompare.repository

import com.robelseyoum3.pricecompare.model.Product
import com.robelseyoum3.pricecompare.network.WebServices
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class GetProductRepositoryImpl  @Inject constructor(private val webServices: WebServices) : Repository {

    override fun getProductRepositoryMethod(): Single<List<Product>> {
        return webServices
            .fetchProductWebService()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
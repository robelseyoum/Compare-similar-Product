package com.robelseyoum3.pricecompare.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.robelseyoum3.pricecompare.model.Product
import com.robelseyoum3.pricecompare.repository.GetProductRepositoryImpl
import io.reactivex.disposables.CompositeDisposable

class ProductViewModel (private val getProductRepositoryImpl: GetProductRepositoryImpl): ViewModel() {

    private var allProductsMutableData: MutableLiveData<List<Product>> = MutableLiveData()
    private var progressbarMutableData: MutableLiveData<Boolean> = MutableLiveData()
    private val errorMutableData: MutableLiveData<Boolean> = MutableLiveData()


    private var compositeDisposable = CompositeDisposable() // we can add several observable

    fun getAllProductData() {

        compositeDisposable.add(

                getProductRepositoryImpl.getProductRepositoryMethod()
                    .doOnSubscribe { progressbarMutableData.postValue(true) }
                    .doOnError { progressbarMutableData.value = false }
                    .subscribe (
                        { product ->
                            allProductsMutableData.value = product
                            progressbarMutableData.value = false
                        },
                        {
                            errorMutableData.value = true
                        }
                    )
            )
    }

    fun returnAllProductsResult() = allProductsMutableData
    fun retunError() = errorMutableData
    fun returnProgressBarValue() = progressbarMutableData


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
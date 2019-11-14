package com.robelseyoum3.pricecompare.model


import com.google.gson.annotations.SerializedName

data class Product(

    @SerializedName("descr")
    val descr: String,

    @SerializedName("mfgDate")
    val mfgDate: String,

    @SerializedName("pId")
    val pId: String,

    @SerializedName("price")
    val price: Price,

    @SerializedName("productName")
    val productName: String
)
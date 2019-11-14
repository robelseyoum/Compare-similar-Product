package com.robelseyoum3.pricecompare.model


import com.google.gson.annotations.SerializedName

data class Amount(

    @SerializedName("rate")
    val rate: String
)
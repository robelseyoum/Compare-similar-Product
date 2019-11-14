package com.robelseyoum3.pricecompare.model


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("amount")
    val amount: Amount,
    @SerializedName("currency")
    val currency: String
)
package com.example.atm.data.model

import com.google.gson.annotations.SerializedName

class TransactionRequest (
    @SerializedName("user_id")
    val user_id: Int = 0,
    @SerializedName("amount")
    val amount: Int = 0,
)
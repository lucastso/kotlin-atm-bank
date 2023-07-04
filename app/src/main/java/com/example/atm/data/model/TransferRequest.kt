package com.example.atm.data.model

import com.google.gson.annotations.SerializedName

class TransferRequest (
    @SerializedName("sender_id")
    val sender_id: Int = 0,
    @SerializedName("recipient_id")
    val recipient_id: Int = 0,
    @SerializedName("amount")
    val amount: Int = 0,
)
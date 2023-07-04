package com.example.atm.data.api

import com.example.atm.data.model.TransactionRequest
import com.example.atm.data.model.TransferRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TransactionService {
    @POST("withdraw")
    fun postWithdraw(@Body transactionRequest: TransactionRequest): Call<String>

    @POST("deposit")
    fun postDeposit(@Body transactionRequest: TransactionRequest): Call<String>

    @GET("balance/{user_id}")
    fun getBalance(@Path("user_id") user_id: Int): Call<Int>

    @GET("transfer")
    fun postTransfer(@Body transactionRequest: TransferRequest): Call<String>
}
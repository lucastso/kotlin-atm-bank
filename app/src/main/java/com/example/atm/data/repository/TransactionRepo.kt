package com.example.atm.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.atm.data.api.RetrofitService
import com.example.atm.data.api.TransactionService
import com.example.atm.data.model.TransactionRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionRepo() {
    companion object {
        val successWithdraw = MutableLiveData<String>()
        val successDeposit = MutableLiveData<String>()
        val failWithdraw = MutableLiveData<String>()
        val failDeposit = MutableLiveData<String>()
        val successBalance = MutableLiveData<Int>()

        fun postWithdraw(transactionRequest: TransactionRequest) {
            val retrofitClient = RetrofitService.getInstance()
            val endpoint = retrofitClient.create(TransactionService::class.java)
            val callback = endpoint.postWithdraw(transactionRequest)

            callback.enqueue(object: Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    successWithdraw.postValue(response.body())
                    println("foi withdraw")
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    failWithdraw.postValue("n foi withdraw")
                    println("n foi withdraw")
                }
            })
        }

        fun postDeposit(transactionRequest: TransactionRequest) {
            val retrofitClient = RetrofitService.getInstance()
            val endpoint = retrofitClient.create(TransactionService::class.java)
            val callback = endpoint.postDeposit(transactionRequest)

            callback.enqueue(object: Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    successDeposit.postValue(response.body())
                    println("foi deposit")
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    failDeposit.postValue("n foi deposit")
                    println("n foi deposit")
                }
            })
        }

        fun getBalance(user_id: Int) {
            val retrofitClient = RetrofitService.getInstance()
            val endpoint = retrofitClient.create(TransactionService::class.java)
            val callback = endpoint.getBalance(user_id)

            callback.enqueue(object: Callback<Int> {
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    successBalance.postValue(response.body())
                    println("foi get balance")
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {

                }
            })
        }
    }
}

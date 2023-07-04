package com.example.atm.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.atm.data.api.RetrofitService
import com.example.atm.data.api.UserService
import com.example.atm.data.model.LoginRequest
import com.example.atm.data.model.RegisterRequest
import com.example.atm.data.model.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepo {
    companion object {
        val successLogin = MutableLiveData<UserModel>()
        val failLogin = MutableLiveData<String>()
        val successRegister = MutableLiveData<UserModel>()
        val failRegister = MutableLiveData<String>()

        fun login(loginRequest: LoginRequest) {
            val retrofitClient = RetrofitService.getInstance()
            val endpoint = retrofitClient.create(UserService::class.java)
            val callback = endpoint.login(loginRequest)

            callback.enqueue(object: Callback<UserModel> {
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    successLogin.postValue(response.body())
                    println("foi withdraw")
                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    failLogin.postValue("n foi withdraw")
                    println("n foi withdraw")
                }
            })
        }

        fun register(registerRequest: RegisterRequest) {
            val retrofitClient = RetrofitService.getInstance()
            val endpoint = retrofitClient.create(UserService::class.java)
            val callback = endpoint.register(registerRequest)

            callback.enqueue(object: Callback<UserModel> {
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    successRegister.postValue(response.body())
                    println("foi deposit")
                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    failRegister.postValue("n foi deposit")
                    println(t.message)
                    println(t.cause)
                }
            })
        }
    }
}
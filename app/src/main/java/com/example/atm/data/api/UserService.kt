package com.example.atm.data.api

import com.example.atm.data.model.LoginRequest
import com.example.atm.data.model.RegisterRequest
import com.example.atm.data.model.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("login")
    fun login(@Body login: LoginRequest): Call<UserModel>

    @POST("register")
    fun register(@Body register: RegisterRequest): Call<UserModel>
}
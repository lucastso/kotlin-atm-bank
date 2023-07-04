package com.example.atm.data.api

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitService {
    companion object {
        private var route: String = "https://10.0.0.139:8000/api/"

        var client: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()
            chain.proceed(newRequest)
        }.build()

        private val retrofitInstance: Retrofit by lazy {
            Retrofit.Builder()
                .client(client)
                .baseUrl(route)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getInstance() : Retrofit {
            return retrofitInstance
        }
    }
}
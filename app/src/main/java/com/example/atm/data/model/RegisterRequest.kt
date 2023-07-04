package com.example.atm.data.model

import com.google.gson.annotations.SerializedName

class RegisterRequest (
    @SerializedName("name")
    val name: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("password")
    val password: String = "",
)
package com.example.atm.data.model

import com.google.gson.annotations.SerializedName

class LoginRequest (
    @SerializedName("name")
    val name: String = "",
    @SerializedName("password")
    val password: String = "",
)
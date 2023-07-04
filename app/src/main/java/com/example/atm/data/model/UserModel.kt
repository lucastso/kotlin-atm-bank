package com.example.atm.data.model

import com.google.gson.annotations.SerializedName

class UserModel (
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("name")
    var name: String = "",
    @SerializedName("email")
    var email: String = "",
    @SerializedName("type")
    var type: String = "",
    @SerializedName("email_verified_at")
    var email_verified_at: String? = "",
    @SerializedName("password")
    var password: String = "",
    @SerializedName("remember_token")
    var remember_token: String = "",
    @SerializedName("created_at")
    var created_at: String = "",
    @SerializedName("updated_at")
    var updated_at: String = ""
)
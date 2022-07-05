package com.hvk.idf.data.models

import com.google.gson.annotations.SerializedName


data class UserLogin(
    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String
)

data class Token(
    @SerializedName("token")
    var token: String
)


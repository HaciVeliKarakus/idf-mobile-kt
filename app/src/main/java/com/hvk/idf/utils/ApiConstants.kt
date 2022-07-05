package com.hvk.idf.utils

import com.google.gson.annotations.SerializedName

class IDFConstants {
    companion object {
        const val IDF_URL = "https://idf.hvk.edu.vn"
        const val IDF_LOGIN_URL = "$IDF_URL/login"
        const val IDF_LOGIN_USERNAME_FIELD = "username"
        const val IDF_LOGIN_PASSWORD_FIELD = "password"
    }

    fun getApiUrl(): String {
        return "http://192.168.10.108:8080/api/"
    }
}

/**
 *
 *
 * Values: created,updated,archived,notMinusChange
 */
enum class ProductStatus(val value: String) {
    @SerializedName("created")
    created("created"),

    @SerializedName("updated")
    updated("updated"),

    @SerializedName("archived")
    archived("archived"),

    @SerializedName("not-change")
    notMinusChange("not-change");
}

enum class MasterStatus(val value: String) {
    @SerializedName("mastered")
    mastered("mastered"),

    @SerializedName("matched")
    matched("matched"),

    @SerializedName("restored")
    restored("restored"),

    @SerializedName("null")
    null_("null");
}
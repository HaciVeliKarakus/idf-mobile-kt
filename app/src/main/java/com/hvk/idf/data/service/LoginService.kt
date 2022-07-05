package com.hvk.idf.data.service

import com.hvk.idf.data.models.Token
import com.hvk.idf.data.models.UserLogin
import com.hvk.idf.data.rest.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST(Constants.LOGIN_URL)
    fun getAuthToken(
        @Body authData: UserLogin
    ): Call<Token>
}


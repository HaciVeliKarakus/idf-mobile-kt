package com.hvk.idf.data.service

import com.hvk.idf.data.models.ProductResponse
import com.hvk.idf.data.rest.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {
    @GET(Constants.PRODUCTS_URL)
    fun getProduct(@Query("page") page: Int): Call<ProductResponse>
}
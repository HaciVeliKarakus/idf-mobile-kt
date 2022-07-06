package com.hvk.idf.data.service

import com.hvk.idf.data.models.ProductResponse
import com.hvk.idf.data.rest.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {
    @GET(Constants.PRODUCTS_URL)
    suspend fun getProduct(
        @Query("page") page: Int,
        @Query("search") search: String,
        @Query("name") name: String,
        @Query("barcode") barcode: String,
        @Query("id") id: String,
    ): ProductResponse
}
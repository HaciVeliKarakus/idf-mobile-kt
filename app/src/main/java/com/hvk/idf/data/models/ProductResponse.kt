package com.hvk.idf.data.models

import java.io.Serializable


//data class

data class ProductResponse(
    val info: Info,
    val links: Links,
    val results: List<ProductModel>
)

data class Info(
    val count: Int,
    val limit: Int,
    val page: Int,
    val time: String,
    val total_pages: Int
)

data class Links(
    val next: String?,
    val previous: String?
)

data class ProductModel(
    val barcode: String?,
    val brand: String?,
    val category: String?,
    val crawler_slug: String?,
    val created_at: String?,
    val currency: String?,
    val description: String?,
    val disc_price: String?,
    val id: String?,
    val image_url: String?,
    val is_master: Boolean?,
    val master_id: String?,
    val master_status: String?,
    val name: String?,
    val price: String?,
    val status: String?,
    val updated_at: String?,
    val url: String?
) : Serializable

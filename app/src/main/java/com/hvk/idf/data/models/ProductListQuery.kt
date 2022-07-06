package com.hvk.idf.data.models

import java.util.*

data class ProductListQuery(
    val search: String,
    val name: String,
    val barcode: String,
    val id: String
)

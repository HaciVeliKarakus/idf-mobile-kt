/**
 * DutyFreeAPI
 *
 * Bordo Bilişim Ticaret Ltd. ŞTİ 2021 ©
 *
 * The version of the OpenAPI document: v1.1.2
 * Contact: haci@bordo.io
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.hvk.idf.data.models


import com.google.gson.annotations.SerializedName
import com.hvk.idf.utils.MasterStatus
import com.hvk.idf.utils.ProductStatus
import java.net.URI
import java.time.OffsetDateTime
import java.util.*

/**
 *
 *
 * @param id id of the product
 * @param updatedAt
 * @param category
 * @param name
 * @param brand
 * @param description
 * @param imageUrl
 * @param status
 * @param crawlerSlug
 * @param currency
 * @param price
 * @param discPrice
 * @param barcode
 * @param url
 * @param createdAt
 * @param isMaster if product is set as master, this field is trueif product is not set as master, this field is falsewhen product is matched any master, this field is false,barcode is set from master barcode
 * @param masterId Master product id that this product is matched to
 * @param masterStatus master product status that about the current productif product is master, this field is set to 'mastered'if product is matched to master, this field is set to 'matched'if product is restored , this field is set to 'restored' then master_id is set to null,is_master is set to false
 */

data class Product(

    /* id of the product */
    @SerializedName("id")
    val id: UUID? = null,

    @SerializedName("updated_at")
    val updatedAt: OffsetDateTime? = null,

    @SerializedName("category")
    val category: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("brand")
    val brand: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("image_url")
    val imageUrl: URI? = null,

    @SerializedName("status")
    val status: ProductStatus? = null,

    @SerializedName("crawler_slug")
    val crawlerSlug: String? = null,

    @SerializedName("currency")
    val currency: String? = null,

    @SerializedName("price")
    val price: String? = null,

    @SerializedName("disc_price")
    val discPrice: String? = null,

    @SerializedName("barcode")
    val barcode: String? = null,

    @SerializedName("url")
    val url: URI? = null,

    @SerializedName("created_at")
    val createdAt: OffsetDateTime? = null,

    /* if product is set as master, this field is trueif product is not set as master, this field is falsewhen product is matched any master, this field is false,barcode is set from master barcode */
    @SerializedName("is_master")
    val isMaster: Boolean? = null,

    /* Master product id that this product is matched to */
    @SerializedName("master_id")
    val masterId: String? = null,

    /* master product status that about the current productif product is master, this field is set to 'mastered'if product is matched to master, this field is set to 'matched'if product is restored , this field is set to 'restored' then master_id is set to null,is_master is set to false */
    @SerializedName("master_status")
    val masterStatus: MasterStatus? = null

)


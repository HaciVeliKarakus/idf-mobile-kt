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
import java.net.URI

/**
 *
 *
 * @param count
 * @param results
 * @param next
 * @param previous
 */

data class GetWebhookList200Response(

    @SerializedName("count")
    val count: Int,

    @SerializedName("results")
    val results: List<Hook>,

    @SerializedName("next")
    val next: URI? = null,

    @SerializedName("previous")
    val previous: URI? = null

)

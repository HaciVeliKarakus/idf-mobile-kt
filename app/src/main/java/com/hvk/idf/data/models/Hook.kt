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
import java.time.OffsetDateTime
import java.util.*

/**
 *
 *
 * @param event
 * @param crawlerSlug Crawler slug for subscription.
 * @param target Target URL to deliver the payload to.
 * @param id unique identifier for current Hook
 * @param createdAt Date and time when this Hook was created.
 * @param updatedAt Date and time when this Hook was updated.
 * @param headers Headers to send with the request.
 */

data class Hook(

    @SerializedName("event")
    val event: Event,

    /* Crawler slug for subscription. */
    @SerializedName("crawler_slug")
    val crawlerSlug: String,

    /* Target URL to deliver the payload to. */
    @SerializedName("target")
    val target: URI,

    /* unique identifier for current Hook */
    @SerializedName("id")
    val id: UUID? = null,

    /* Date and time when this Hook was created. */
    @SerializedName("created_at")
    val createdAt: OffsetDateTime? = null,

    /* Date and time when this Hook was updated. */
    @SerializedName("updated_at")
    val updatedAt: OffsetDateTime? = null,

    /* Headers to send with the request. */
    @SerializedName("headers")
    val headers: kotlin.Any? = null

) {

    /**
     *
     *
     * Values: added,changed,removed
     */
    enum class Event(val value: String) {
        @SerializedName("product.added")
        added("product.added"),

        @SerializedName("product.changed")
        changed("product.changed"),

        @SerializedName("product.removed")
        removed("product.removed");
    }
}

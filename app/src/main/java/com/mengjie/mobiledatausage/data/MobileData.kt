package com.mengjie.mobiledatausage.data

import com.google.gson.annotations.SerializedName

data class MobileData(
    val help: String,
    val success: Boolean,
    val result: Result
)

data class Result(
    @SerializedName("resource_id")
    val resourceId: String,
    val fields: List<Field>,
    val records: List<Record>,
    @SerializedName("_links")
    val links: Link,
    val limit: Int,
    val total: Int
)

data class Record(
    @SerializedName("volume_of_mobile_data")
    val volumeOfMobileData: String,
    val quarter: String,
    @SerializedName("_id")
    val id: Int
)

data class Field(
    val type: String,
    val id: String
)

data class Link(
    val start: String,
    val next: String
)

data class UsageDisplayItem(
    val year: String,
    val totalUsage: String,
    val quarter: List<Record>
)
package com.alamre.demokotlin

import com.google.gson.annotations.SerializedName

data class Note(
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("body")
    var body: String? = null,
    @SerializedName("picture_url")
    var pictureUrl: String? = null
)
package com.dicoding.myopenmusic.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SongsItemResponse(

    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("performer")
    val performer: String,

    @field:SerializedName("title")
    val title: String

)

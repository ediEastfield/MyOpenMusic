package com.dicoding.myopenmusic.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListSongsResponse(

    @field:SerializedName("data")
    val data: SongsResponse,

    @field:SerializedName("status")
    val status: String

)

package com.dicoding.myopenmusic.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SongsResponse(

    @field:SerializedName("songs")
    val songs: List<SongsItemResponse>

)

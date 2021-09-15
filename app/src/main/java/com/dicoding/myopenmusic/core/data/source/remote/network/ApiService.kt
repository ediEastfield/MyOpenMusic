package com.dicoding.myopenmusic.core.data.source.remote.network

import com.dicoding.myopenmusic.core.data.source.remote.response.ListSongsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("songs")
    suspend fun getSongs(): ListSongsResponse
}
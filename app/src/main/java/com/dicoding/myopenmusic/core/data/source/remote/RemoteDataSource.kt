package com.dicoding.myopenmusic.core.data.source.remote

import android.util.Log
import com.dicoding.myopenmusic.core.data.source.remote.network.ApiResponse
import com.dicoding.myopenmusic.core.data.source.remote.network.ApiService
import com.dicoding.myopenmusic.core.data.source.remote.response.SongsItemResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllSongs(): Flow<ApiResponse<List<SongsItemResponse>>> {
        return flow {
            try {
                val response = apiService.getSongs()
                val dataArray = response.data.songs
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.data.songs))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}
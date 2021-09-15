package com.dicoding.myopenmusic.core.data

import com.dicoding.myopenmusic.core.data.source.local.LocalDataSource
import com.dicoding.myopenmusic.core.data.source.remote.RemoteDataSource
import com.dicoding.myopenmusic.core.data.source.remote.network.ApiResponse
import com.dicoding.myopenmusic.core.data.source.remote.response.SongsItemResponse
import com.dicoding.myopenmusic.core.domain.model.Songs
import com.dicoding.myopenmusic.core.domain.repository.IMyOpenMusicRepository
import com.dicoding.myopenmusic.core.utils.AppExecutors
import com.dicoding.myopenmusic.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyOpenMusicRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMyOpenMusicRepository {

    override fun getAllSongs(): Flow<Resource<List<Songs>>> =
        object : NetworkBoundResource<List<Songs>, List<SongsItemResponse>>() {
            override fun loadFromDB(): Flow<List<Songs>> {
                return localDataSource.getAllSongs().map {
                    DataMapper.mapSongsEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Songs>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<SongsItemResponse>>> =
                remoteDataSource.getAllSongs()

            override suspend fun saveCallResult(data: List<SongsItemResponse>) {
                val songsList = DataMapper.mapSongsResponseToEntities(data)
                localDataSource.insertSongs(songsList)
            }
        }.asFlow()
}
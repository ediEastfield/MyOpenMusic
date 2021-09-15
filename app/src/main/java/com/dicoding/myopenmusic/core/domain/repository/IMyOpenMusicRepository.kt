package com.dicoding.myopenmusic.core.domain.repository

import com.dicoding.myopenmusic.core.data.Resource
import com.dicoding.myopenmusic.core.domain.model.Songs
import kotlinx.coroutines.flow.Flow

interface IMyOpenMusicRepository {

    fun getAllSongs(): Flow<Resource<List<Songs>>>

}
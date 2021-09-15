package com.dicoding.myopenmusic.core.domain.usecase

import com.dicoding.myopenmusic.core.data.Resource
import com.dicoding.myopenmusic.core.domain.model.Songs
import kotlinx.coroutines.flow.Flow

interface MyOpenMusicUseCase {
    fun getAllSongs(): Flow<Resource<List<Songs>>>
}
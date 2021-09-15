package com.dicoding.myopenmusic.core.data.source.local

import com.dicoding.myopenmusic.core.data.source.local.entity.SongsItemEntity
import com.dicoding.myopenmusic.core.data.source.local.room.MyOpenMusicDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val myOpenMusicDao: MyOpenMusicDao) {

    fun getAllSongs(): Flow<List<SongsItemEntity>> = myOpenMusicDao.getAllSongs()

    suspend fun insertSongs(songs: List<SongsItemEntity>) = myOpenMusicDao.insertSongs(songs)
}
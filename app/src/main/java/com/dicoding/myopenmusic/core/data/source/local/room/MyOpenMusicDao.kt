package com.dicoding.myopenmusic.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dicoding.myopenmusic.core.data.source.local.entity.SongsItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MyOpenMusicDao {

    @Query("SELECT * FROM songs")
    fun getAllSongs(): Flow<List<SongsItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongs(songs: List<SongsItemEntity>)
}
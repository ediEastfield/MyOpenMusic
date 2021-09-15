package com.dicoding.myopenmusic.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.myopenmusic.core.data.source.local.entity.SongsItemEntity

@Database(
    entities =  [
        SongsItemEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MyOpenMusicDatabase : RoomDatabase() {

    abstract fun myOpenMusicDao(): MyOpenMusicDao

}
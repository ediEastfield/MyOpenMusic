package com.dicoding.myopenmusic.core.di

import android.content.Context
import androidx.room.Room
import com.dicoding.myopenmusic.core.data.source.local.room.MyOpenMusicDao
import com.dicoding.myopenmusic.core.data.source.local.room.MyOpenMusicDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MyOpenMusicDatabase = Room.databaseBuilder(
        context,
        MyOpenMusicDatabase::class.java,
        "OpenMusic.db"
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideMyOpenMusicDao(database: MyOpenMusicDatabase): MyOpenMusicDao = database.myOpenMusicDao()
}
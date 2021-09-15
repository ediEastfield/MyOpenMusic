package com.dicoding.myopenmusic.core.di

import com.dicoding.myopenmusic.core.data.MyOpenMusicRepository
import com.dicoding.myopenmusic.core.domain.repository.IMyOpenMusicRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(myOpenMusicRepository: MyOpenMusicRepository): IMyOpenMusicRepository
}
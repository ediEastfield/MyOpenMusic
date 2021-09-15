package com.dicoding.myopenmusic.di

import com.dicoding.myopenmusic.core.domain.usecase.MyOpenMusicInteractor
import com.dicoding.myopenmusic.core.domain.usecase.MyOpenMusicUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideMyOpenMusicUseCase(myOpenMusicInteractor: MyOpenMusicInteractor): MyOpenMusicUseCase
}
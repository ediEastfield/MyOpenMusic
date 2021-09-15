package com.dicoding.myopenmusic.core.domain.usecase

import com.dicoding.myopenmusic.core.domain.repository.IMyOpenMusicRepository
import javax.inject.Inject

class MyOpenMusicInteractor @Inject constructor(private val myOpenMusicRepository: IMyOpenMusicRepository) : MyOpenMusicUseCase {

    override fun getAllSongs() = myOpenMusicRepository.getAllSongs()

}
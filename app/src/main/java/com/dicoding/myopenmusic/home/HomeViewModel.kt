package com.dicoding.myopenmusic.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.myopenmusic.core.domain.usecase.MyOpenMusicUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(myOpenMusicUseCase: MyOpenMusicUseCase) : ViewModel() {
    val songs = myOpenMusicUseCase.getAllSongs().asLiveData()
}
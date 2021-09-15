package com.dicoding.myopenmusic.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Songs(
    val songId: String,
    val title: String,
    val performer: String
) : Parcelable
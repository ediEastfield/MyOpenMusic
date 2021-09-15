package com.dicoding.myopenmusic.core.utils

import com.dicoding.myopenmusic.core.data.source.local.entity.SongsItemEntity
import com.dicoding.myopenmusic.core.data.source.remote.response.SongsItemResponse
import com.dicoding.myopenmusic.core.domain.model.Songs

object DataMapper {
    fun mapSongsResponseToEntities(input: List<SongsItemResponse>) : List<SongsItemEntity> {
        val songsList = ArrayList<SongsItemEntity>()
        input.map {
            val song = SongsItemEntity(
                songId = it.id,
                title = it.title,
                performer = it.performer
            )
            songsList.add(song)
        }
        return songsList
    }

    fun mapSongsEntitiesToDomain(input: List<SongsItemEntity>): List<Songs> =
        input.map {
            Songs(
                songId = it.songId,
                title = it.title,
                performer = it.performer
            )
        }
}
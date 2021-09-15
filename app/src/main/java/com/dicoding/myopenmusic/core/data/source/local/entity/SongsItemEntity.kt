package com.dicoding.myopenmusic.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "songs")
data class SongsItemEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "songId")
    var songId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "performer")
    var performer: String
)

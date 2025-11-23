package org.dieschnittstelle.mobile.android.kotlin.skeleton.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.System.currentTimeMillis

@Entity(tableName = "mediaItems")
data class MediaItem(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val title: String,
    val src: String,
    val createDate: Long = currentTimeMillis(),
)

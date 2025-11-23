package org.dieschnittstelle.mobile.android.kotlin.skeleton.local.item

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.dieschnittstelle.mobile.android.kotlin.skeleton.model.MediaItem

@Database(entities = [MediaItem::class], version = 1)
abstract class MediaItemDatabase : RoomDatabase() {
    abstract fun mediaItemDAO(): MediaItemDao

    companion object {
        @Volatile
        private var Instance: MediaItemDatabase? = null

        fun getDatabase(context: Context): MediaItemDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, MediaItemDatabase::class.java, "mediaItem_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
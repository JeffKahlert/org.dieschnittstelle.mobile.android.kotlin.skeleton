package org.dieschnittstelle.mobile.android.kotlin.skeleton

import android.content.Context
import org.dieschnittstelle.mobile.android.kotlin.skeleton.local.item.MediaItemDatabase
import org.dieschnittstelle.mobile.android.kotlin.skeleton.local.item.MediaItemRepository
import org.dieschnittstelle.mobile.android.kotlin.skeleton.local.item.OfflineMediaItemRepositoryImpl


interface AppContainer {
    val mediaItemRepository: MediaItemRepository
}
class AppDataContainer(
    private val context: Context
) : AppContainer {

    override val mediaItemRepository: MediaItemRepository by lazy {
        OfflineMediaItemRepositoryImpl(MediaItemDatabase.getDatabase(context).mediaItemDAO())
    }
}
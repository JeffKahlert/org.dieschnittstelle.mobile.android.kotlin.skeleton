package org.dieschnittstelle.mobile.android.kotlin.skeleton.ui.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.dieschnittstelle.mobile.android.kotlin.skeleton.local.item.MediaItemRepository
import org.dieschnittstelle.mobile.android.kotlin.skeleton.model.MediaItem

class MediaItemViewModel(
    saveStateHandle: SavedStateHandle,
    private val mediaItemRepository: MediaItemRepository
) : ViewModel() {

    val mediaItemListUiState: StateFlow<MediaItemListUiState> =
        mediaItemRepository.getAllMediaItemsStream().map { MediaItemListUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = MediaItemListUiState()
            )


    suspend fun insertMediaItem(mediaItem: MediaItem) =
        mediaItemRepository.insertMediaItem(mediaItem)
}

data class MediaItemListUiState(
    val mediaItems: List<MediaItem> = emptyList()
)
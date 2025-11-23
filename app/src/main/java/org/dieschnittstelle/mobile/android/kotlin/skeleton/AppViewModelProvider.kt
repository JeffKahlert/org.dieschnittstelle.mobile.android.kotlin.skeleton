package org.dieschnittstelle.mobile.android.kotlin.skeleton

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import org.dieschnittstelle.mobile.android.kotlin.skeleton.ui.list.MediaItemViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            MediaItemViewModel(
                this.createSavedStateHandle(),
                ProjektApplication().container.mediaItemRepository
            )
        }
    }
}

fun CreationExtras.projektApplication(): ProjektApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as ProjektApplication)
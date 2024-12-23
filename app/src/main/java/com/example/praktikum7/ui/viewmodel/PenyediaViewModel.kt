package com.example.praktikum7.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.praktikum7.KrsApp

object PenyediaViewModel {
    val Factory = viewModelFactory {
        // MahasiswaViewModel
        initializer {
            MahasiswaViewModel(
                krsApp().containerApp.repositoryMhs
            )
        }

        // HomeMhsViewModel
        initializer {
            HomeMhsViewModel(
                krsApp().containerApp.repositoryMhs
            )
        }

        // DetailMhsViewModel
        initializer {
            DetailMhsViewModel(
                createSavedStateHandle(),
                krsApp().containerApp.repositoryMhs
            )
        }

        // UpdateMhsViewModel
        initializer {
            UpdateMhsViewModel(
                createSavedStateHandle(),
                krsApp().containerApp.repositoryMhs
            )
        }
    }
}

fun CreationExtras.krsApp(): KrsApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KrsApp)
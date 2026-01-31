package com.example.ucp2.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2.viewmodel.DetailViewModel
import com.example.ucp2.viewmodel.EditViewModel
import com.example.ucp2.viewmodel.EntryViewModel

object PenyediaViewModel {
        val Factory = viewModelFactory {
            initializer {
                HomeViewModel(aplikasiSiswa().container.repositoriSiswa)
            }

            initializer {
                EntryViewModel(aplikasiSiswa().container.repositoriSiswa)
            }

            initializer {
                DetailViewModel(
                    this.createSavedStateHandle(),
                    aplikasiSiswa().container.repositoriSiswa
                )
            }

            initializer {
                EditViewModel(
                    this.createSavedStateHandle(),
                    aplikasiSiswa().container.repositoriSiswa
                )
            }
        }
    }


    fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
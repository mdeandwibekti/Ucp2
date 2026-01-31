package com.example.ucp2.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.repository.RepositoriHotel
import com.example.ucp2.room.kamar
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriHotel: RepositoriHotel
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateHotel())
        private set

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetailHotel.itemIdArg])

    init {
        viewModelScope.launch {
            uiStateSiswa = repositoriHotel.getHotelStream(idHotel)
                .filterNotNull()
                .first()
                .toUIStateHotel(true)
        }
    }

    fun updateUiState(detailKamar: DetailKamar) {
        uiStateSiswa =
            UIStateKamar(detailKamar: DetailKamar, isEntryValid = validasiInput(detailKamar))
    }

    private fun validasiInput(detailSiswa: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(detailSiswa) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    suspend fun updateSiswa() {
        if (validasiInput(uiStateSiswa.detailSiswa)) {
            repositoriSiswa.updateSiswa(uiStateSiswa.detailSiswa.toSiswa())
        }
    }
}
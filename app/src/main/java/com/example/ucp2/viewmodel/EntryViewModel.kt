package com.example.ucp2.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ucp2.repository.RepositoriHotel
import com.example.ucp2.room.kamar
import kotlin.Int


class EntryViewModel(private val repositoriHotel: RepositoriHotel) : ViewModel() {

    var uiState by mutableStateOf(UIState())
        private set



    fun updateUIState(detail: DetailKamar) {
        uiState =
            UIStateKamar(detailKamar = detail, isEntryValid = validasiInput(detail))
    }

    suspend fun saveKamar() {
        if (validasiInput()) {
            repositoriHotel.insertKamar(uiStateKamar.detailKamar.tokamar())
        }
    }
}

data class UIStateKamar(
    val detailKamar: DetailKamar = detailKamar(),
    val isEntryValid: Boolean = false
)

annotation class DetailKamar

/* Fungsi untuk mengkonversi data input ke data dalam tabel sesuai jenis datanya */
fun DetailKamar.toKamar(): Kamar = Kamar(
    val id: Int = 0,
    val nokamar: Int = 0,
    val kapasitas: String,
    val status: String,
)

fun kamar.toUIStatekamar(isEntryValid: Boolean = false): UIStateKamar = UIStateKamar(
    detailKamar = this.toDetailKamar(),
    isEntryValid = isEntryValid
)

fun kamar.toDetailKamar(): DetailKamar = DetailKamar(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telfon
)
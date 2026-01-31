package com.example.ucp2.viewmodel

import android.R.attr.id
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2.repository.RepositoriHotel
import com.example.ucp2.view.route.DestinasiDetailHotel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriHotel: RepositoriHotel
) : ViewModel(){

    private val id: Int = checkNotNull(savedStateHandle[DestinasiDetailHotel.itemIdArg])

    val uiDetailState: StateFlow<DetailHotelUiState> =
        repositoriHotel.getKamarStream(id)
            .filterNotNull()
            .map {
                DetailHotelUiState(detailKamar = it.toDetailHotel())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailHotelUiState()
            )
    suspend fun deletekamar(){
        repositoriHotel.deleteKamar(uiDetailState.value.detailKamar.toKamar())
    }

    suspend fun deleteTipeKamar(){
        repositoriHotel.deleteTipeKamar(uiDetailState.value.detailTipeKamar.toTipeKamar())
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * UI state for ItemDetailsScreen
 */
data class DetailHotelUiState(
    val detailSiswa: DetailKamar =DetailSiswa()
)
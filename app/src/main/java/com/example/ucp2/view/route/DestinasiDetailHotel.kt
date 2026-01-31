package com.example.ucp2.view.route

import com.example.ucp2.R

object DestinasiDetailHotel : DestinasiNavigasi {
    override val route = "detail_hotel"
    override val titleRes = R.string.detail_hotel
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"

}
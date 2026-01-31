package com.example.ucp2.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableTipeKamar = "tblTipeKamar")
data class Tipekamar(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val namatipe: String,
)
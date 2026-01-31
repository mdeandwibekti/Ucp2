package com.example.ucp2.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableKamar = "tblKamar")
data class kamar(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nokamar: Int = 0,
    val kapasitas: String,
    val status: String,
)
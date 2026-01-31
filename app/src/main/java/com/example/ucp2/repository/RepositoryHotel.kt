package com.example.ucp2.repository

import com.example.ucp2.room.KamarDao
import com.example.ucp2.room.TipeKamarDao
import com.example.ucp2.room.Tipekamar
import com.example.ucp2.room.kamar
import kotlinx.coroutines.flow.Flow


interface RepositoriHotel{
    fun getAllTipeKamarStream(): Flow<List<Tipekamar>>
    fun getAllKamarStream(): Flow<List<kamar>>

    suspend fun insertTipeKamar(tipekamar: Tipekamar)
    suspend fun insertKamar(kamar: kamar)

    suspend fun deleteTipeKamar(tipekamar: Tipekamar)
    suspend fun deleteKamar(kamar: kamar)

    suspend fun updatekamar(kamar: kamar)
    fun getKamarStream(idKamar: Any)
}



class OfflineRepositoriHotel(
    private val kamarDao: KamarDao,
    private val tipekamar: Tipekamar
): RepositoriHotel{
    override fun getAllTipeKamarStream(): Flow<List<Tipekamar>> = TipeKamarDao.getAllTipeKamar()
    override fun getAllKamarStream(): Flow<List<kamar>> = KamarDao.getAllKamar()

    override suspend fun insertTipeKamar(tipekamar: Tipekamar) = TipeKamarDao.insert(tipekamar)
    override suspend fun insertKamar(kamar: kamar) {
    }

    override fun getkamarStream(id: Int): Flow<kamar?>


    override suspend fun deleteTipeKamar(tipekamar: Tipekamar)


    override suspend fun deleteKamar(kamar: kamar)


    override suspend fun updatekamar(kamar: kamar)

}

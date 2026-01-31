package com.example.ucp2.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface KamarDao {

    @Query(value = "SELECT * from tblKamar ORDER BY nokamar ASC")
    fun getAllTipeKamar(): Flow<List<kamar>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(kamar: kamar)

    @Query("SELECT * from tblKamar WHERE id = :id" )
    fun getSiswa(id: Int ): Flow<kamar?>

    @Delete
    suspend fun delete(kamar: kamar)

    @Update
    suspend fun update(kamar: kamar)
}
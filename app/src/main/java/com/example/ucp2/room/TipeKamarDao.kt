package com.example.ucp2.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TipeKamarDao {

    @Query(value = "SELECT * from tblTipeKamar ORDER BY nama ASC")
    fun getAllTipeKamar(): Flow<List<Tipekamar>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tipekamar: Tipekamar)

    @Query("SELECT * from tblTipeKamar WHERE id = :id" )
    fun getTipeKamar(id: Int ): Flow<Tipekamar?>

    @Delete
    suspend fun delete(tipekamar: Tipekamar)

    @Update
    suspend fun update(tipekamar: Tipekamar)

    companion object
}
package com.example.ucp2.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tipekamar::class], version = 1, exportSchema = false)
abstract class DatabaseHotel : RoomDatabase(){
    abstract fun TipeKamarDao(): TipeKamarDao

    companion object{
        @volatile
        private var Instance : DatabaseHotel? = null

        fun getDatabase(context: Context): DatabaseHotel{
            return Instance ?: synchronized(this){
                Companion.
                Room.databaseBuilder(
                    context, DatabaseHotel::class.java,
                    "Siswa database")
                    .build().also {Instance }
            })
        }
    }
}
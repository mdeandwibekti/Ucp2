package com.example.ucp2.repository

import android.app.Application
import android.content.Context
import com.example.ucp2.room.DatabaseHotel

open class ContainerApp {
    val repositoriHotel : RepositoriHotel
}

class ContainerDataApp(private val context: Context):
    ContainerApp() {
    override val repositoriHotel: RepositoriHotel by lazy {
        OfflineRepositoriHotel(
            DatabaseHotel.getDatabase(context).TipeKamarDao())
    }
}

class AplikasiHotel : Application() {
    lateinit var container:ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}


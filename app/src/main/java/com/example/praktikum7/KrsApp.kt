package com.example.praktikum7

import android.app.Application
import com.example.praktikum7.dependenciesinjection.ContainerApp

class KrsApp : Application() {
    //Fungsinya untuk menyimpan instance ContainerApp
    lateinit var containerApp: ContainerApp

    override fun onCreate(){
        super.onCreate()
        //Membuat instance ContainerApp
        containerApp = ContainerApp(this)
        //Instance adalah objek yang dibuat dari class
    }
}
package com.example.praktikum7.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.praktikum7.data.dao.MahasiswaDao
import com.example.praktikum7.data.entity.Mahasiswa

//Mendefinisikan database dengan nama Mahasiswa
@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {
    //Mendefinisikan fungsi untuk mengakses data Mahasiswa
    abstract fun mahasiswaDao() : MahasiswaDao

    companion object {
        @Volatile //Memastikan bahwa nilai variabel instance selalu sama di semua thread
        private var Instance : KrsDatabase? = null

        fun getDatabase(context: Context) : KrsDatabase { //Cara buat databasenya
            return (Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java, //Class Database
                    "KrsDatabase" //Nama database
                )
                    .build().also { Instance = it }
            })
        }
    }
}
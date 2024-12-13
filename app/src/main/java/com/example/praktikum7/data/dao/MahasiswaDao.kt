package com.example.praktikum7.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.praktikum7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

@Dao
interface MahasiswaDao {
    //Fungsi get all data
    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC ")
    fun getAllMahasiswa() = Flow<List<Mahasiswa>>

    @Query("SELECT * FROM mahasiswa WHERE nim =: nim ")
    fun getMahasiswa(nim: String): Flow<Mahasiswa>
}
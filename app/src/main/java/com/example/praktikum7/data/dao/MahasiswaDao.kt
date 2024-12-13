package com.example.praktikum7.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.praktikum7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

@Dao
interface MahasiswaDao {
    //Fungsi get all data
    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC ")
    fun getAllMahasiswa() = Flow<List<Mahasiswa>>

    @Insert //Selain insert bisa update dsb
    suspend fun insertMahasiswa(
        mahasiswa: Mahasiswa //Manggil entitas mahasiswa
    )
}
package com.example.ummuathiya

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface AlumniDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlumni(alumni: AlumniModel)

    @Query("SELECT * FROM alumni")
    fun getAlumni(): LiveData<List<AlumniModel>>

    @Delete
    suspend fun deleteAlumni(alumni: AlumniModel)

    @Update
    suspend fun updateAlumni(alumni: AlumniModel)

    @Query("SELECT * FROM alumni WHERE nim=:nim LIMIT 1")
    fun getSingleAlumni(nim: String): AlumniModel

}
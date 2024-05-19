package com.example.ummuathiya

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("alumni")
data class AlumniModel(
    @PrimaryKey
    val nim: String,
    val nama: String,
    val tempatLahir: String,
    val tanggalLahir: String,
    val alamat: String,
    val agama: String,
    val noTelp: String,
    val tahunMasuk: String,
    val tahunLulus: String,
    val pekerjaan: String,
    val jabatan: String
)
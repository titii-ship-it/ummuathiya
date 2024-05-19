package com.example.ummuathiya

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar

class DetailAlumniActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_alumni)

        val database = DatabaseHelper.getInstance(applicationContext)
        val dao = database.alumniDao()

        val edtNim = findViewById<EditText>(R.id.edtNimDetail)
        val edtNama = findViewById<EditText>(R.id.edtAlumniDetail)
        val edtTempat = findViewById<EditText>(R.id.edtTempatDetail)
        val edtTanggal = findViewById<EditText>(R.id.edtTanggalDetail)
        val edtAlamat = findViewById<EditText>(R.id.edtAlamatDetail)
        val edtAgama = findViewById<EditText>(R.id.edtAgamaDetail)
        val edtNoTelp = findViewById<EditText>(R.id.edtTlpDetail)
        val edtTahunMasuk = findViewById<EditText>(R.id.edtTahunMasukDetail)
        val edtTahunLulus = findViewById<EditText>(R.id.edtTahunLulusDetail)
        val edtPekerjaan = findViewById<EditText>(R.id.edtPekerjaanDetail)
        val edtJabatan = findViewById<EditText>(R.id.edtJabatanDetail)
        val updateBtn = findViewById<Button>(R.id.updateBtn)
        val deleteBtn = findViewById<Button>(R.id.deleteBtn)

        val nim = intent.getStringExtra("nim")
        if (nim != null) {
            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    val alumni = dao.getSingleAlumni(nim)
                    edtNim.setText(alumni.nim)
                    edtNama.setText(alumni.nama)
                    edtTempat.setText(alumni.tempatLahir)
                    edtTanggal.setText(alumni.tanggalLahir)
                    edtAlamat.setText(alumni.alamat)
                    edtNoTelp.setText(alumni.noTelp)
                    edtAgama.setText(alumni.agama)
                    edtTahunMasuk.setText(alumni.tahunMasuk)
                    edtTahunLulus.setText(alumni.tahunLulus)
                    edtPekerjaan.setText(alumni.pekerjaan)
                    edtJabatan.setText(alumni.jabatan)
                }
            }
        }

        updateBtn.setOnClickListener {
            val nim = edtNim.text.toString()
            val nama = edtNama.text.toString()
            val tempat = edtTempat.text.toString()
            val tanggal = edtTanggal.text.toString()
            val alamat = edtAlamat.text.toString()
            val agama = edtAgama.text.toString()
            val noTelp = edtNoTelp.text.toString()
            val tahunMasuk = edtTahunMasuk.text.toString()
            val tahunLulus = edtTahunLulus.text.toString()
            val pekerjaan = edtPekerjaan.text.toString()
            val jabatan = edtJabatan.text.toString()
            val alumni = AlumniModel(
                nim = nim,
                nama = nama,
                tempatLahir = tempat,
                tanggalLahir = tanggal,
                alamat = alamat,
                agama = agama,
                noTelp = noTelp,
                tahunMasuk = tahunMasuk,
                tahunLulus = tahunLulus,
                pekerjaan = pekerjaan,
                jabatan = jabatan
            )

            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    dao.updateAlumni(alumni)
                    finish()
                }
            }
        }

        deleteBtn.setOnClickListener {
            val nim = edtNim.text.toString()
            val nama = edtNama.text.toString()
            val tempat = edtTempat.text.toString()
            val tanggal = edtTanggal.text.toString()
            val alamat = edtAlamat.text.toString()
            val agama = edtAgama.text.toString()
            val noTelp = edtNoTelp.text.toString()
            val tahunMasuk = edtTahunMasuk.text.toString()
            val tahunLulus = edtTahunLulus.text.toString()
            val pekerjaan = edtPekerjaan.text.toString()
            val jabatan = edtJabatan.text.toString()
            val alumni = AlumniModel(
                nim = nim,
                nama = nama,
                tempatLahir = tempat,
                tanggalLahir = tanggal,
                alamat = alamat,
                agama = agama,
                noTelp = noTelp,
                tahunMasuk = tahunMasuk,
                tahunLulus = tahunLulus,
                pekerjaan = pekerjaan,
                jabatan = jabatan
            )

            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    dao.deleteAlumni(alumni)
                    finish()
                }
            }
        }

        edtTanggal.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    edtTanggal.setText(selectedDate)
                    Toast.makeText(this, "Selected date: $selectedDate", Toast.LENGTH_SHORT).show()
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }
    }
}
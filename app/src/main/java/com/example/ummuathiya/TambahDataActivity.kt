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

class TambahDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_data)

        val database = DatabaseHelper.getInstance(applicationContext)
        val dao = database.alumniDao()

        val edtNim = findViewById<EditText>(R.id.edtNimTambah)
        val edtNama = findViewById<EditText>(R.id.edtAlumniTambah)
        val edtTempat = findViewById<EditText>(R.id.edtTempatTambah)
        val edtTanggal = findViewById<EditText>(R.id.edtTanggalTambah)
        val edtAlamat = findViewById<EditText>(R.id.edtAlamatTambah)
        val edtAgama = findViewById<EditText>(R.id.edtAgamaTambah)
        val edtNoTelp = findViewById<EditText>(R.id.edtTlpTambah)
        val edtTahunMasuk = findViewById<EditText>(R.id.edtTahunMasukTambah)
        val edtTahunLulus = findViewById<EditText>(R.id.edtTahunLulusTambah)
        val edtPekerjaan = findViewById<EditText>(R.id.edtPekerjaanTambah)
        val edtJabatan = findViewById<EditText>(R.id.edtJabatanTambah)
        val simpanBtn = findViewById<Button>(R.id.saveBtn)

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

        simpanBtn.setOnClickListener {
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
                    dao.insertAlumni(alumni)
                    finish()
                }
            }
        }
    }
}
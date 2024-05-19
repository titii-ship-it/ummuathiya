package com.example.ummuathiya

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar

class InputDataMahasiswa : AppCompatActivity() {
    private lateinit var edtNama: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtJurusan: EditText
    private lateinit var edtKelas: EditText
    private lateinit var edtTanggalLahir: EditText
    private lateinit var edtJamLahir: EditText
    private lateinit var actionSimpan: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_data_mahasiswa)
        edtNama = findViewById<EditText>(R.id.edtNama)
        edtEmail = findViewById<EditText>(R.id.edtEmail)
        edtJurusan = findViewById<EditText>(R.id.edtJurusan)
        edtKelas = findViewById<EditText>(R.id.edtKelas)
        edtTanggalLahir = findViewById<EditText>(R.id.edtTanggalLahir)
        edtJamLahir = findViewById<EditText>(R.id.edtJamLahir)
        actionSimpan = findViewById<Button>(R.id.actionSimpan)
//        actionSimpan.setOnClickListener(View.OnClickListener { simpan() })
        edtTanggalLahir.setOnClickListener(View.OnClickListener { showTanggalLahir() })
        edtJamLahir.setOnClickListener(View.OnClickListener { showJamLahir() })
    }

    fun showTanggalLahir() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            this, listenerDate,
            calendar[Calendar.YEAR], calendar[Calendar.MONTH], calendar[Calendar.DAY_OF_MONTH]
        ).show()
    }

    fun showJamLahir() {
        val calendar = Calendar.getInstance()
        TimePickerDialog(
            this, listenerTime,
            calendar[Calendar.HOUR_OF_DAY], calendar[Calendar.MINUTE], true
        ).show()
    }

    var listenerDate =
        OnDateSetListener { view, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar[Calendar.YEAR] = year
            calendar[Calendar.MONTH] = month
            calendar[Calendar.DAY_OF_MONTH] = dayOfMonth
            val dateFormat = SimpleDateFormat("dd MMMM yyyy")
            edtTanggalLahir!!.setText(dateFormat.format(calendar.time))
        }
    var listenerTime =
        OnTimeSetListener { view, hourOfDay, minute ->
            val calendar = Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY] = hourOfDay
            calendar[Calendar.MINUTE] = minute
            val timeFormat = SimpleDateFormat("HH:mm")
            edtJamLahir!!.setText(timeFormat.format(calendar.time))
        }

//    fun simpan() {
//        val contentValues = ContentValues()
//        contentValues.put(DatabaseHelper._COLUMN_NAMA, edtNama!!.getText().toString())
//        contentValues.put(DatabaseHelper._COLUMN_EMAIL, edtEmail!!.getText().toString())
//        contentValues.put(DatabaseHelper._COLUMN_JURUSAN, edtJurusan!!.getText().toString())
//        contentValues.put(DatabaseHelper._COLUMN_KELAS, edtKelas!!.getText().toString())
//        contentValues.put(
//            DatabaseHelper._COLUMN_TANGGAL_LAHIR,
//            edtTanggalLahir!!.getText().toString()
//        )
//        contentValues.put(DatabaseHelper._COLUMN_JAM_LAHIR, edtJamLahir!!.getText().toString())
//        val db: SQLiteDatabase = DatabaseHelper(this).getWritableDatabase()
//        val insert = db.insert(DatabaseHelper._TABLE_MAHASISWA, null, contentValues)
//        if (insert != -1L) {
//            Toast.makeText(this, "Simpan Data Berhasil", Toast.LENGTH_SHORT).show()
//            finish()
//        }
//    }
}
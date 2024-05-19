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

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtBod: EditText
    private lateinit var edtJamLahir: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtNama: EditText
    private lateinit var actionSimpan: Button
    var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        edtNama = findViewById<EditText>(R.id.edtNama)
        edtEmail = findViewById<EditText>(R.id.edtEmail)
        edtPassword = findViewById<EditText>(R.id.edtPassword)
        actionSimpan = findViewById<Button>(R.id.actionSimpan)
        edtBod = findViewById<EditText>(R.id.edtBod)
        edtJamLahir = findViewById<EditText>(R.id.edtJamLahir)
        edtBod.setOnClickListener(this)
        edtJamLahir.setOnClickListener(this)
        actionSimpan.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.edtBod ->                 //event click BOD
                DatePickerDialog(
                    this, dateSetListener, calendar[Calendar.YEAR],
                    calendar[Calendar.MONTH], calendar[Calendar.DAY_OF_MONTH]
                ).show()

            R.id.edtJamLahir ->                 //event click Jam Lahir
                TimePickerDialog(
                    this, timeSetListener, calendar[Calendar.HOUR_OF_DAY],
                    calendar[Calendar.MINUTE], true
                ).show()
        }
    }

    var dateSetListener =
        OnDateSetListener { view, year, month, dayOfMonth ->
            calendar[Calendar.YEAR] = year
            calendar[Calendar.MONTH] = month
            calendar[Calendar.DAY_OF_MONTH] = dayOfMonth
            val dateFormat = SimpleDateFormat("dd MMMM yyyy")
            edtBod.setText(dateFormat.format(calendar.time))
        }
    var timeSetListener =
        OnTimeSetListener { view, hourOfDay, minute ->
            calendar[Calendar.HOUR_OF_DAY] = hourOfDay
            calendar[Calendar.MINUTE] = minute
            val timeFormat = SimpleDateFormat("HH:mm")
            edtJamLahir.setText(timeFormat.format(calendar.time))
        }
}
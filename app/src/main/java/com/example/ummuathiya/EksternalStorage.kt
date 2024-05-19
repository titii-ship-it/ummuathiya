package com.example.ummuathiya

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader

class EksternalStorage : AppCompatActivity() {
    private lateinit var actionBuat: Button
    private lateinit var actionUbah: Button
    private lateinit var actionBaca: Button
    private lateinit var actionHapus: Button
    private lateinit var edtInput: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_storage)
        actionBuat = findViewById<Button>(R.id.actionBuat)
        actionUbah = findViewById<Button>(R.id.actionUbah)
        actionBaca = findViewById<Button>(R.id.actionBaca)
        actionHapus = findViewById<Button>(R.id.actionHapus)
        edtInput = findViewById<EditText>(R.id.edtInput)
        actionBuat.setOnClickListener(View.OnClickListener {
            if (periksaIzinPenyimpanan()) {
                buatData()
            }
        })
        actionBaca.setOnClickListener(View.OnClickListener {
            if (periksaIzinPenyimpanan()) {
                bacaData()
            }
        })
        actionUbah.setOnClickListener(View.OnClickListener {
            if (periksaIzinPenyimpanan()) {
                ubahData()
            }
        })
        actionHapus.setOnClickListener(View.OnClickListener {
            if (periksaIzinPenyimpanan()) {
                hapusData()
            }
        })
    }

    fun buatData() {
        val data = edtInput.getText().toString()
        val file = File(Environment.getExternalStorageDirectory(), FILENAME)
        var outputStream: FileOutputStream? = null
        try {
            file.createNewFile()
            outputStream = FileOutputStream(file, false)
            outputStream.write(data.toByteArray())
            outputStream.flush()
            outputStream.close()
        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)
        }
    }

    fun bacaData() {
        val file = File(Environment.getExternalStorageDirectory(), FILENAME)
        if (file.exists()) {
            val text = StringBuilder()
            try {
                val bufferedReader = BufferedReader(FileReader(file))
                var line = bufferedReader.readLine()
                while (line != null) {
                    text.append(line)
                    line = bufferedReader.readLine()
                }
                bufferedReader.close()
            } catch (e: Exception) {
                Log.e("ERROR", "" + e.message)
            }
            edtInput.setText(text.toString())
        }
    }

    fun ubahData() {
        val data = edtInput.getText().toString()
        val file = File(Environment.getExternalStorageDirectory(), FILENAME)
        var outputStream: FileOutputStream? = null
        try {
            file.createNewFile()
            outputStream = FileOutputStream(file, false)
            outputStream.write(data.toByteArray())
            outputStream.flush()
            outputStream.close()
        } catch (e: Exception) {
            Log.e("ERROR", "" + e.message)
        }
    }

    fun hapusData() {
        val file = File(Environment.getExternalStorageDirectory(), FILENAME)
        if (file.exists()) {
            file.delete()
        }
    }

    fun periksaIzinPenyimpanan(): Boolean {
        return if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                true
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ),
                    request_code
                )
                false
            }
        } else {
            true
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            request_code -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@EksternalStorage, "Izin Berhasil", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        var FILENAME = "bacaan.txt"
        const val request_code = 100
    }
}
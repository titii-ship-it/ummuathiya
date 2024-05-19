package com.example.ummuathiya

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader

class InternalStorage : AppCompatActivity() {
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
        actionBuat.setOnClickListener(View.OnClickListener { buatData() })
        actionBaca.setOnClickListener(View.OnClickListener { bacaData() })
        actionUbah.setOnClickListener(View.OnClickListener { ubahData() })
        actionHapus.setOnClickListener(View.OnClickListener { hapusData() })
    }

    fun buatData() {
        val data = edtInput!!.getText().toString()
        val file = File(filesDir, FILENAME)
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
        val file = File(filesDir, FILENAME)
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
        val file = File(filesDir, FILENAME)
        val outputStream: FileOutputStream?
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
        val file = File(filesDir, FILENAME)
        if (file.exists()) {
            file.delete()
        }
    }

    companion object {
        var FILENAME = "bacaan.txt"
    }
}
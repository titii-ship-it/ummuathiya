package com.example.ummuathiya

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var edtUname: EditText
    private lateinit var edtPass: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtUname = findViewById(R.id.edtUname)
        edtPass = findViewById(R.id.edtPass)
        btnLogin = findViewById(R.id.btnLogin)
        Log.d("TAG", "test")
        Log.d("TAG", edtPass.text.toString())

        btnLogin.setOnClickListener {
            Log.d("TAG", edtUname.text.toString())
            Log.d("TAG", edtPass.text.toString())
            if (edtUname.text.toString().equals("athiya@mail.com") && edtPass.text.toString()
                    .equals("0909")
            ) {
                val data = getSharedPreferences("Profile", Context.MODE_PRIVATE)
                val edit = data.edit()
                edit.putString("email", "athiya@mail.com")
                edit.putString("nim", "2207411005")
                edit.putString("nama", "Ummu Athiya")
                edit.putString("kelas", "TI-4A")
                edit.apply()

                val pindah = Intent(applicationContext, MainActivity::class.java)
                startActivity(pindah)
                finish()
            }
            else{
                Toast.makeText(applicationContext,"Login Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
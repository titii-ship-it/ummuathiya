package com.example.ummuathiya

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences
    private lateinit var txtEmail: TextView
    private lateinit var txtNama: TextView
    private lateinit var actionInternalStorage: Button
    private lateinit var actionEksternalStorage: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        preferences = getSharedPreferences("profile", MODE_PRIVATE)
        txtEmail = findViewById<TextView>(R.id.txtEmail)
        txtNama = findViewById<TextView>(R.id.txtNama)
        actionInternalStorage = findViewById<Button>(R.id.actionInternal)
        actionEksternalStorage = findViewById<Button>(R.id.actionEksternalStorage)
        txtEmail.setText(preferences.getString("email", ""))
        txtNama.setText(preferences.getString("nama", ""))
        actionInternalStorage.setOnClickListener(View.OnClickListener {
            val intent = Intent(
                this@HomeActivity,
                InternalStorage::class.java
            )
            startActivity(intent)
        })
        actionEksternalStorage.setOnClickListener(View.OnClickListener {
            val intent = Intent(
                this@HomeActivity,
                EksternalStorage::class.java
            )
            startActivity(intent)
        })
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.menu_home, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.menu_tambah) {
//            val tambah = Intent(
//                this@HomeActivity,
//                InputDataMahasiswa::class.java
//            )
//            startActivity(tambah)
//        } else {
//        }
//        return super.onOptionsItemSelected(item)
//    }
}
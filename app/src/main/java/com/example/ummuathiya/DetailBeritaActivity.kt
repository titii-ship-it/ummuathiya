package com.example.ummuathiya

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailBeritaActivity : AppCompatActivity() {
    private lateinit var imgBerita: ImageView
    private lateinit var txtJudul: TextView
    private lateinit var txtIsi: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)
        imgBerita = findViewById<ImageView>(R.id.imgBerita)
        txtJudul = findViewById<TextView>(R.id.txtJudul)
        txtIsi = findViewById<TextView>(R.id.txtIsiBerita)
        val extras = intent.extras
        if (extras != null) {
            Picasso.get().load(extras.getString("image", "")).into(imgBerita)
            txtIsi.text = extras.getString("isi", "")
            txtJudul.text = extras.getString("judul", "")
        }
    }
}
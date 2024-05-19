package com.example.ummuathiya

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData

class DataAlumniActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase
    private lateinit var dao: AlumniDao
    private var alumniList = MutableLiveData<List<AlumniModel>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_alumni)

        database = DatabaseHelper.getInstance(applicationContext)
        dao = database.alumniDao()
        dao.getAlumni().observe(this) {
            alumniList.value = it ?: emptyList()
        }

        alumniList.observe(this) {
            val arrayAdapter: ArrayAdapter<AlumniModel> = AlumniAdapter(
                this,
                alumniList.value ?: emptyList(),
                onItemClickListener = {
                    val pindah = Intent(applicationContext, DetailAlumniActivity::class.java)
                    pindah.putExtra("nim", it)
                    startActivity(pindah)
                }
            )
            val listView = findViewById<ListView>(R.id.alumniListView)
            listView.adapter = arrayAdapter
        }
    }
}
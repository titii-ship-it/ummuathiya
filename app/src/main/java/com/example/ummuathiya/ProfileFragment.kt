package com.example.ummuathiya

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val email = view.findViewById<EditText>(R.id.edtEmailProfile)
        val nim = view.findViewById<EditText>(R.id.edtNim)
        val nama = view.findViewById<EditText>(R.id.edtNamaProfile)
        val kelas = view.findViewById<EditText>(R.id.edtKelasProfile)
        val logout = view.findViewById<Button>(R.id.logoutBtn)

        val sharedPref = activity?.getSharedPreferences("Profile", AppCompatActivity.MODE_PRIVATE)
        if (sharedPref != null) {
            val dataEmail = sharedPref.getString("email", "") ?: ""
            val dataNim = sharedPref.getString("nim", "") ?: ""
            val dataNama = sharedPref.getString("nama", "") ?: ""
            val dataKelas = sharedPref.getString("kelas", "") ?: ""
            Log.d("TAG", "$dataEmail, $dataNim, $dataNama, $dataKelas")
            email.setText(dataEmail)
            nim.setText(dataNim)
            nama.setText(dataNama)
            kelas.setText(dataKelas)
        }

        logout.setOnClickListener {
            val editor = sharedPref?.edit()
            editor?.clear()
            editor?.apply()
            val pindah = Intent(context, LoginActivity::class.java)
            startActivity(pindah)
            activity?.finish()
        }

        return view
    }

}
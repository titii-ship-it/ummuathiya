package com.example.ummuathiya

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomnavigation.BottomNavigationView

class BeritaDetailFragment : Fragment() {

    private val args: BeritaDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_berita_detail, container, false)

        val artikel = args.artikel
        val model = listBerita[artikel]
        val image = view.findViewById<ImageView>(R.id.imgBeritaDetail)
        val judul = view.findViewById<TextView>(R.id.txtJudulDetail)
        val isi = view.findViewById<TextView>(R.id.txtIsiBeritaDetail)
        image.setImageResource(model.image)
        judul.text = model.judul
        isi.text = model.isi

        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.visibility = View.GONE

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.visibility = View.VISIBLE
    }
}
package com.example.ummuathiya

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class BeritaAdapter(
    context: Context,
    objects: Array<BeritaModel>,
    private val onItemClickListener: (Int) -> Unit
): ArrayAdapter<BeritaModel>(context, R.layout.item_berita_layout, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.item_berita_layout, parent, false)
        } else {
            view = convertView
        }

        val berita = getItem(position)

        val image = view.findViewById<ImageView>(R.id.imgBerita)
        val judul = view.findViewById<TextView>(R.id.txtJudul)

        if (berita != null) {
            image.setImageResource(berita.image)
            judul.text = berita.judul
        }

        view.setOnClickListener { onItemClickListener(position) }

        return view
    }
}
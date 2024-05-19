package com.example.ummuathiya

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class AlumniAdapter(
    context: Context,
    objects: List<AlumniModel>,
    private val onItemClickListener: (String) -> Unit
): ArrayAdapter<AlumniModel>(context, R.layout.item_alumni_layout, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.item_alumni_layout, parent, false)
        } else {
            view = convertView
        }

        val alumni = getItem(position)

        val nim = view.findViewById<TextView>(R.id.txtNim)
        val name = view.findViewById<TextView>(R.id.txtName)

        if (alumni != null) {
            nim.text = alumni.nim
            name.text = alumni.nama
            view.setOnClickListener { onItemClickListener(alumni.nim) }
        }

        return view
    }
}
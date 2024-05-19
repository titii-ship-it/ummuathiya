package com.example.ummuathiya

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.navigation.fragment.findNavController


class BeritaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_berita, container, false)

        val arrayAdapter: ArrayAdapter<BeritaModel> = BeritaAdapter(
            requireContext(),
            listBerita,
            onItemClickListener = {
                val action = BeritaFragmentDirections.actionBeritaFragmentToBeritaDetailFragment(it)
                findNavController().navigate(action)
            }
        )
        val listView = view.findViewById<ListView>(R.id.listView)
        listView.adapter = arrayAdapter

        return view
    }
}
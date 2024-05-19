package com.example.ummuathiya

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class LatihanListActivity : AppCompatActivity() {
    var listView: ListView? = null
    var items = arrayOf("Satu", "Dua", "Tiga")
//    var adapterBerita: AdapterBerita? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_list)
        listView = findViewById<ListView>(R.id.listView)
        //        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_expandable_list_item_1,items);
//        listView.setAdapter(adapter);
//        adapterBerita = AdapterBerita(this, R.layout.item_berita_layout)
//        listView.setAdapter(adapterBerita)
        loadDataList()
//        listView.setOnItemClickListener(OnItemClickListener { parent, view, position, id ->
//            val model: BeritaModel = parent.adapter.getItem(position) as BeritaModel
//            val intent = Intent(
//                this@LatihanListActivity,
//                DetailBeritaActivity::class.java
//            )
//            intent.putExtra("image", model.getImage())
//            intent.putExtra("judul", model.getJudulBerita())
//            intent.putExtra("isi", model.getIsiBerita())
//            startActivity(intent)
//        })
    }

    fun loadDataList() {
        val image = arrayOf(
            "https://akcdn.detik.net.id/community/media/visual/2020/10/26/adv-transpark.jpeg?w=700&q=90",
            "https://akcdn.detik.net.id/community/media/visual/2020/10/27/kapolsek-mampang-prapatan-kompol-sujarwo-didampingi-kanit-reskrim-iptu-sigit-dan-kasubag-humas-akprita-1_169.jpeg?w=700&q=90",
            "https://akcdn.detik.net.id/community/media/visual/2020/10/27/temuan-indikasi-kehidupan-di-venus-sebuah-kesalahan-pengukuran.jpeg?w=700&q=90"
        )
        val judul = arrayOf(
            "Vaksin COVID-19 Ditemukan, Saatnya Berburu Investasi Properti",
            "Alarm Berbunyi, 2 Pria Ini Gagal Curi Motor di Mampang Jaksel",
            "Temuan Indikasi Kehidupan di Venus, Sebuah Kesalahan Pengukuran?"
        )
        val isiBerita = arrayOf(
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        )
//        for (i in image.indices) {
//            val model = BeritaModel()
//            model.setImage(image[i])
//            model.setJudulBerita(judul[i])
//            model.setIsiBerita(isiBerita[i])
//            adapterBerita.add(model)
//        }
//        adapterBerita.notifyDataSetChanged()
    }
}
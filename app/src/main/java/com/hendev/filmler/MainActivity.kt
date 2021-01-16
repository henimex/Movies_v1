package com.hendev.filmler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var kategoriListe: ArrayList<Kategoriler>
    private lateinit var adapter: KatagoriAdapter
    private lateinit var vt: VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        copyDBtoDevice()

        toolbar.title = "  Kategoriler"
        toolbar.setLogo(R.drawable.movie)
        setSupportActionBar(toolbar)

        kategoriRv.setHasFixedSize(true)
        kategoriRv.layoutManager = LinearLayoutManager(this)

        vt = VeritabaniYardimcisi(this)
        kategoriListe = KategorilerDao().tumKategoriler(vt)
        adapter = KatagoriAdapter(this, kategoriListe)
        kategoriRv.adapter=adapter

        toolbar.subtitle = "    ${kategoriListe.count()} Kategori Listelendi"
    }

    fun copyDBtoDevice(){
    val copyHelper= DatabaseCopyHelper(this)
    try {
        copyHelper.createDataBase()
        copyHelper.openDataBase()
    }catch (e: Exception){
        e.printStackTrace()
    }
}
}
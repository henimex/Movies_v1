package com.hendev.filmler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_filmler.*
import kotlinx.android.synthetic.main.activity_main.*

class FilmlerActivity : AppCompatActivity() {

    private lateinit var filmListe :ArrayList<Filmler>
    private lateinit var adapter: FilmlerAdapter
    private lateinit var vt: VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filmler)

        val kategori = intent.getSerializableExtra("kategoriNesne") as Kategoriler

        toolbarFilmler.title = "    Filmler : ${kategori.kategori_ad}"
        toolbarFilmler.setLogo(R.drawable.movie)
        setSupportActionBar(toolbarFilmler)

        filmlerRv.setHasFixedSize(true)
        filmlerRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        vt = VeritabaniYardimcisi(this)
        filmListe = FilmlerDao().ilgiliFilmlerByKategori(vt, kategori.kategori_id)

        adapter= FilmlerAdapter(this,filmListe)
        filmlerRv.adapter=adapter

        toolbarFilmler.subtitle = "    ${filmListe.count()} Film Listelendi"
    }
}
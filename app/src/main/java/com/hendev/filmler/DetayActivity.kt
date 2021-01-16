package com.hendev.filmler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    private lateinit var filmListe : ArrayList<Filmler>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        filmListe = ArrayList()

        val film = intent.getSerializableExtra("filmlerNesne") as Filmler

        txtDetayFilmAdi.text = film.film_ad
        txtDetayFilmYil.text = film.film_yil.toString()
        txtDetayYonetmen.text = film.yonetmen.yonetmen_ad
        imgDetay.setImageResource(resources.getIdentifier(film.film_resim,"drawable",packageName))
    }
}
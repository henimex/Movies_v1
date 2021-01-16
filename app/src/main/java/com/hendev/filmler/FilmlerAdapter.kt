package com.hendev.filmler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FilmlerAdapter(private val mContext: Context, private val filmlerListe: List<Filmler>) :
    RecyclerView.Adapter<FilmlerAdapter.designHolder>() {

    inner class designHolder(x: View) : RecyclerView.ViewHolder(x) {
        var film_card: CardView
        var txtFilmAdi: TextView
        var imgFilm: ImageView

        init {
            film_card = x.findViewById(R.id.film_card)
            txtFilmAdi = x.findViewById(R.id.txtFilmAdi)
            imgFilm = x.findViewById(R.id.imgFilm)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): designHolder {
        val _design =
            LayoutInflater.from(mContext).inflate(R.layout.film_card_tasarim, parent, false)
        return designHolder(_design)
    }

    override fun onBindViewHolder(holder: designHolder, position: Int) {
        val film = filmlerListe[position]
        holder.txtFilmAdi.text = film.film_ad
        holder.imgFilm.setImageResource(mContext.resources.getIdentifier(film.film_resim,"drawable",mContext.packageName))

        holder.film_card.setOnClickListener {
            val intent = Intent(mContext,DetayActivity::class.java)
            intent.putExtra("filmlerNesne",film)
            mContext.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return filmlerListe.size
    }
}
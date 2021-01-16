package com.hendev.filmler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class KatagoriAdapter(private val mContext: Context, private val kategoriListe: List<Kategoriler>)
    : RecyclerView.Adapter<KatagoriAdapter.designHolder>() {

    inner class designHolder(x:View) : RecyclerView.ViewHolder(x) {
        var kategoriCard: CardView
        var txtKategoriAd : TextView

        init {
            kategoriCard = x.findViewById(R.id.kategoriCard)
            txtKategoriAd = x.findViewById(R.id.txtKategoriAd)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): designHolder {
        val _design = LayoutInflater.from(mContext).inflate(R.layout.kategori_card_tasarim,parent,false)
        return designHolder(_design)
    }

    override fun onBindViewHolder(holder: designHolder, position: Int) {
        val kategori = kategoriListe[position]
        holder.txtKategoriAd.text = kategori.kategori_ad

        holder.kategoriCard.setOnClickListener {
            val intent = Intent(mContext,FilmlerActivity::class.java) //geçiş yapılacak activity ile değişecek !!!!!
            intent.putExtra("kategoriNesne",kategori)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return kategoriListe.size
    }

}
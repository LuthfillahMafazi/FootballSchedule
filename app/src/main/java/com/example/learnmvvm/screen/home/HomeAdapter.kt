package com.example.learnmvvm.screen.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.learnmvvm.R
import com.example.learnmvvm.data.model.FootballLeagueModel
import kotlinx.android.synthetic.main.item_league.view.*

class HomeAdapter (private val context: Context, private val footballLeagueModel: List<FootballLeagueModel>)
    : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_league, parent, false))
    }

    override fun getItemCount(): Int = footballLeagueModel.size

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.bindItem(footballLeagueModel[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(footballLeagueModel: FootballLeagueModel) {
            val name = itemView.nameFootballTV
            val gambar = itemView.footballItemIV

            name.text = footballLeagueModel.nama
            Glide.with(itemView.context).load(footballLeagueModel.foto).into(gambar)
        }

    }
}

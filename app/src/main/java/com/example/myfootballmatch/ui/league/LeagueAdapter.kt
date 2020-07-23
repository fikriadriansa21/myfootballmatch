package com.example.myfootballmatch.ui.league

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.model.League
import kotlinx.android.synthetic.main.item_rv_league.view.*

class LeagueAdapter(listener: LeagueListener) : RecyclerView.Adapter<ViewHolder>(){

    interface LeagueListener {
        fun onLeagueListener(id: Int)
    }

    lateinit var listener: LeagueListener

    var arrList: ArrayList<League> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_league, parent, false))

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(arrList[position].flag)
            .into(holder.imageViewClub)

        holder.textViewClub.text = arrList[position].name
        holder.itemView.setOnClickListener {
            listener.onLeagueListener(arrList[position].league_id)
        }
    }


}

class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    val imageViewClub: ImageView = view.iv_league_logo
    val textViewClub: TextView = view.findViewById(R.id.tv_league_name)
}
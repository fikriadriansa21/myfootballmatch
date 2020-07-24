package com.example.myfootballmatch.ui.squad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.model.player.Player

class SquadAdapter(private var listener: SquadListener) : RecyclerView.Adapter<SquadAdapter.ViewHolder>(){

    private var arrList : List<Player?> =  ArrayList<Player>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewPlayerName: TextView = view.findViewById(R.id.tv_league_name)
        val textViewPlayerPosition: TextView = view.findViewById(R.id.tv_league_name)
    }

    fun setItems(items: List<Player?>) {
        arrList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_league, parent, false))

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewPlayerName.text = arrList?.get(position)?.player_name
        holder.textViewPlayerName.text = arrList?.get(position)?.position
        holder.itemView.setOnClickListener {
            arrList?.get(position)?.player_id?.let { it1 -> listener.onSquadListener(it1) }
        }
    }

    interface SquadListener {
        fun onSquadListener(id: Int)
    }
}
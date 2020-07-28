package com.krayz.myfootballmatch.ui.squad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.data.network.model.player.Player

class SquadAdapter() : RecyclerView.Adapter<SquadAdapter.ViewHolder>(){

    private var arrList : List<Player?> =  ArrayList<Player>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewPlayerName: TextView = view.findViewById(R.id.tv_player_name_squad)
        val textViewPlayerPosition: TextView = view.findViewById(R.id.tv_position_player)
    }

    fun setItems(items: List<Player?>) {
        arrList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false))

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewPlayerName.text = arrList[position]!!.player_name
        holder.textViewPlayerPosition.text = arrList[position]!!.position
    }

}
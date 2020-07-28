package com.krayz.myfootballmatch.ui.statistic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.data.network.model.player.Player

class StatisticAdapter(private var listener: StatisticListener) : RecyclerView.Adapter<StatisticAdapter.ViewHolder>(){

    private var arrList : List<Player?> =  ArrayList<Player?>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewRank: TextView = view.findViewById(R.id.tv_pos_number)

    }

    fun setItems(items: List<Player>) {
        arrList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_table_klasemen, parent, false))

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    interface StatisticListener {
        fun onStatisticListener(id: Int)
    }
}
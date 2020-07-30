package com.krayz.myfootballmatch.ui.statistic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.data.network.model.player.Player
import com.krayz.myfootballmatch.data.network.model.statistic.Statistic
import com.krayz.myfootballmatch.data.network.model.statistic.matchs.Draws
import com.krayz.myfootballmatch.data.network.model.statistic.matchs.Loses
import com.krayz.myfootballmatch.data.network.model.statistic.matchs.Wins
import com.krayz.myfootballmatch.data.network.model.statistic.matchs.matchsPlayed.MatchsPlayed

class StatisticAdapter() : RecyclerView.Adapter<StatisticAdapter.ViewHolder>(){

    private lateinit var matchsPlayed : MatchsPlayed
    private lateinit var wins: Wins
    private lateinit var draws: Draws
    private lateinit var loses: Loses

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewRank: TextView = view.findViewById(R.id.tv_pos_number)

    }

    fun setItemsMatchPlayed(items: MatchsPlayed) {
        matchsPlayed = items
        notifyDataSetChanged()
    }

    fun setItemsWins(items: Wins) {
        wins = items
        notifyDataSetChanged()
    }

    fun setItemsDraws(items: Draws) {
        draws = items
        notifyDataSetChanged()
    }

    fun setItemsLoses(items: Loses) {
        loses = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_table_klasemen, parent, false))

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

}
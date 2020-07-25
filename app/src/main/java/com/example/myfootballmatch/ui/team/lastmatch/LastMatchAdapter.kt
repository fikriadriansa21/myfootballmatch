package com.example.myfootballmatch.ui.team.lastmatch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.model.fixture.Fixture
import com.example.myfootballmatch.data.network.model.fixture.away.AwayTeam
import com.example.myfootballmatch.data.network.model.fixture.home.HomeTeam

class LastMatchAdapter(private var listener: LastMatchListener) : RecyclerView.Adapter<LastMatchAdapter.ViewHolder>(){

    private var arrList : List<Fixture?> =  ArrayList<Fixture>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageViewClubHome: ImageView = view.findViewById(R.id.iv_club_logo_fav_team)
        val imageViewClubAway: ImageView = view.findViewById(R.id.iv_club_logo_opponent)
        val textViewClubHome: TextView = view.findViewById(R.id.tv_team_nick_name)
        val textViewClubAway: TextView = view.findViewById(R.id.tv_team_nick_name_opponent)
        val textViewHomeScore: TextView = view.findViewById(R.id.tv_score_club)
        val textViewAwayScore: TextView = view.findViewById(R.id.tv_score_opponent)

    }

    fun setItems(items: List<Fixture?>) {
        arrList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_league, parent, false))

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(arrList[position]!!.homeTeam.logo)
            .into(holder.imageViewClubHome)

        Glide.with(holder.itemView.context)
            .load(arrList[position]!!.awayTeam.logo)
            .into(holder.imageViewClubAway)

        holder.textViewClubHome.text = arrList[position]!!.homeTeam.team_name
        holder.textViewClubAway.text = arrList[position]!!.awayTeam.team_name
        holder.textViewHomeScore.text = arrList[position]!!.goalsHomeTeam.toString()
        holder.textViewAwayScore.text = arrList[position]!!.goalsAwayTeam.toString()
        holder.itemView.setOnClickListener {
            listener.onLastMatchListener(arrList[position]!!.fixture_id!!)
        }
    }

    interface LastMatchListener {
        fun onLastMatchListener(id: Int)
    }
}
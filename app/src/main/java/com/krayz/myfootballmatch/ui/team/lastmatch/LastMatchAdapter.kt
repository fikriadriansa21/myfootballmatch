package com.krayz.myfootballmatch.ui.team.lastmatch

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.data.network.model.fixture.Fixture
import org.joda.time.format.ISODateTimeFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList


class LastMatchAdapter(private var listener: LastMatchListener) : RecyclerView.Adapter<LastMatchAdapter.ViewHolder>(){

    private var arrList : List<Fixture?> =  ArrayList<Fixture>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageViewClubHome: ImageView = view.findViewById(R.id.iv_home_club)
        val imageViewClubAway: ImageView = view.findViewById(R.id.iv_away_club)
        val textViewClubHome: TextView = view.findViewById(R.id.tv_home_team)
        val textViewClubAway: TextView = view.findViewById(R.id.tv_away_team)
        val textViewScoreHome: TextView = view.findViewById(R.id.tv_score_home_team)
        val textViewScoreAway: TextView = view.findViewById(R.id.tv_score_away_team)
        val textViewDateMatch: TextView = view.findViewById(R.id.tv_date)
    }

    fun setItems(items: List<Fixture?>) {
        arrList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_latest_match_team, parent, false))

    override fun getItemCount(): Int {
        return arrList.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(arrList[position]!!.homeTeam.logo)
            .into(holder.imageViewClubHome)
        Glide.with(holder.itemView.context)
            .load(arrList[position]!!.awayTeam.logo)
            .into(holder.imageViewClubAway)

        holder.textViewClubHome.text = arrList[position]!!.homeTeam.team_name
        holder.textViewClubAway.text = arrList[position]!!.awayTeam.team_name
        holder.textViewScoreHome.text = arrList[position]!!.goalsHomeTeam.toString()
        holder.textViewScoreAway.text = arrList[position]!!.goalsAwayTeam.toString()

        if (arrList[position]!!.event_date != ""){
            val outputFormatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy", Locale.getDefault())
            val date = LocalDate.parse(arrList[position]!!.event_date, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            val formattedDate = outputFormatter.format(date)
            holder.textViewDateMatch.text = formattedDate
        }

        holder.itemView.setOnClickListener {
            listener.onLastMatchListener(arrList[position]!!.fixture_id)
        }
    }

    interface LastMatchListener {
        fun onLastMatchListener(id: Int)
    }

}
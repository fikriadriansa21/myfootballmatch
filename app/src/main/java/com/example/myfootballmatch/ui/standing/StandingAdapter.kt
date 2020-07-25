package com.example.myfootballmatch.ui.standing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfootballmatch.R
import com.example.myfootballmatch.data.network.model.standing.Standing

class StandingAdapter(private var listener: StandingListener) : RecyclerView.Adapter<StandingAdapter.ViewHolder>(){

    private var arrList : List<List<Standing?>> =  ArrayList<List<Standing?>>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewRank: TextView = view.findViewById(R.id.tv_pos_number)
        val textViewClub: TextView = view.findViewById(R.id.tv_club_name)
        val textViewGame: TextView = view.findViewById(R.id.tv_play_game)
        val textViewGoalDrawn: TextView = view.findViewById(R.id.tv_goal_drawn)
        val textViewPoints: TextView = view.findViewById(R.id.tv_points_gained)
    }

    fun setItems(items: List<List<Standing>>) {
        arrList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_table_klasemen, parent, false))

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewClub.text = arrList[0][position]!!.teamName
        holder.textViewRank.text = arrList[0][position]!!.rank.toString()
        holder.textViewGoalDrawn.text =arrList[0][position]!!.goalsDiff.toString()
//        holder.textViewGame.text = arrList[0][position]!!.all.matchsPlayed.toString()
        holder.textViewPoints.text = arrList[0][position]!!.points.toString()
        holder.itemView.setOnClickListener {
            listener.onStandingListener(arrList[0][position]!!.team_id)

        }
    }

    interface StandingListener {
        fun onStandingListener(id: Int)
    }
}
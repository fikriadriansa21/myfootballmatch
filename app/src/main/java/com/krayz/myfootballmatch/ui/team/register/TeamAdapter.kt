package com.krayz.myfootballmatch.ui.team.register

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.krayz.myfootballmatch.R
import com.krayz.myfootballmatch.data.network.model.team.byleagueid.Team


class TeamAdapter(private var listener: TeamListener) : RecyclerView.Adapter<TeamAdapter.ViewHolder>(){

    private var arrList : List<Team?> =  ArrayList<Team>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageViewClub: ImageView = view.findViewById(R.id.iv_team_logo)
        val textViewClub: TextView = view.findViewById(R.id.tv_team_name)
    }

    fun setItems(items: List<Team?>) {
        arrList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_team, parent, false)
        )

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(arrList[position]!!.logo)
            .into(holder.imageViewClub)

        holder.textViewClub.text = arrList?.get(position)?.name
        holder.itemView.setOnClickListener {
            listener.onTeamListener(arrList[position]!!.team_id!!, arrList[position]!!.name,
                arrList[position]!!.logo
            )
        }

    }

    interface TeamListener {
        fun onTeamListener(id: Int, name: String, logo: String)
    }
}

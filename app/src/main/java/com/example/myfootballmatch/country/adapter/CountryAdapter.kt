package com.example.myfootballmatch.country.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfootballmatch.R
import com.example.myfootballmatch.country.model.Country
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(list: ArrayList<Country>) : RecyclerView.Adapter<ViewHolder>(){

    var arrList: ArrayList<Country> = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false))

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(arrList[position].flag)
            .into(holder.imageViewFlag)

        holder.textViewCountry.text = arrList[position].country
    }

}

class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    val imageViewFlag: ImageView = view.iv_country
    val textViewCountry: TextView = view.findViewById(R.id.tv_country_name)
}
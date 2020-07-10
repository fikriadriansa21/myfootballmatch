package com.example.myfootballmatch.country.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfootballmatch.R
import com.example.myfootballmatch.country.model.Country

//class CountryAdapter(list: ArrayList<Country>) : RecyclerView.Adapter<ViewHolder>(){
//
//    var arrList: ArrayList<Country> = list
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
//            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_makanan, parent, false))
//
//    override fun getItemCount(): Int {
//        return arrList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        Glide.with(holder.itemView.context)
//            .load(arrList[position].image)
//            .into(holder.imageViewMakanan)
//
//        holder.textViewMakanan.text = arrList[position].title
//        holder.textViewKalori.text = arrList[position].calories.toString()
//
//
//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, DetailMakananActivity::class.java)
//            intent.putExtra("data_detail", arrList[position])
//            holder.itemView.context.startActivity(intent)
//        }
//
//    }
//
//}
//
//class ViewHolder(view: View): RecyclerView.ViewHolder(view){
//    val imageViewMakanan: ImageView = view.iv_makanan
//    val textViewMakanan: TextView = view.findViewById(R.id.tv_nama_makanan)
//    val textViewKalori: TextView = view.findViewById(R.id.tv_kalori_angka)
//}
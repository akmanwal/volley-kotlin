package com.akmanwal.rcvkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akmanwal.rcvkotlin.model.Restaurant
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_item.view.*

class MyAdapter(val namesList: ArrayList<Restaurant>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        )
    }

    override fun getItemCount(): Int {

        return namesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val obj = namesList[position]
        val name = obj.name
        val url = obj.backgroundImageURL

        holder.view.tvName.text = name
        Glide.with(context).load(url).into(holder.view.ivImage)
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
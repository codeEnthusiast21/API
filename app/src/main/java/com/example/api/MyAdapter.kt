package com.example.api

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context:Activity,val productArrayList: List<Product>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemview= LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentitem = productArrayList[position]
        holder.title.text = currentitem.title
        holder.desc.text = currentitem.description
        Picasso.get().load(currentitem.thumbnail).into(holder.image)

        }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    var title :TextView
    var image :ShapeableImageView
    var desc : TextView
    init{
        title = itemView.findViewById(R.id.prdctname)
        desc = itemView.findViewById(R.id.description)
        image=itemView.findViewById(R.id.prodcutimage)
    }

    }
}
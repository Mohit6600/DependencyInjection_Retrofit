package com.example.dependencyinjection_retrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinjection_retrofit.retrofit.response.post_response.ProductItem
import com.example.dependencyinjection_retrofit.R

class MyAdapter(val context: Context, val myProductList: List<ProductItem>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

        var id = itemView.findViewById<TextView>(R.id.id)
        var title = itemView.findViewById<TextView>(R.id.title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val item = LayoutInflater.from(context).inflate(R.layout.raw_items,parent,false)
        return ViewHolder(item)
    }

    override fun getItemCount(): Int {
     return myProductList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.id.text = myProductList[position].id.toString()
        holder.title.text = myProductList[position].title

    }
}

package com.example.dependencyinjection_retrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinjection_retrofit.retrofit.response.post_response.ProductItem
import com.example.dependencyinjection_retrofit.R
import com.example.dependencyinjection_retrofit.database.UserData
import com.example.dependencyinjection_retrofit.retrofit.response.login_response.LoginResponse
import com.example.dependencyinjection_retrofit.retrofit.response.post_response.User

class MyAdapter(private val context: Context, private val myProductList: List<UserData>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var username = itemView.findViewById<TextView>(R.id.username)
        var password = itemView.findViewById<TextView>(R.id.password)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(context).inflate(R.layout.raw_items, parent, false)
        return ViewHolder(item)
    }

    override fun getItemCount(): Int {
        return myProductList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.username.text = myProductList[position].userName
        /*  holder.password.text = myProductList[position].password*/

    }

}

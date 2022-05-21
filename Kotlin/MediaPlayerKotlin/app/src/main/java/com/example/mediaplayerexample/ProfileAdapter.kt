package com.example.mediaplayerexample

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ProfileAdapter(val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return CustomViewHolder(view).apply{
            itemView.setOnClickListener{

            }
        }
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.album.setImageResource(profileList.get(position).album)
        holder.title.text = profileList.get(position).title
        holder.singer.text = profileList.get(position).singer
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val album = itemView.findViewById<ImageView>(R.id.rv_album)
        val title = itemView.findViewById<TextView>(R.id.rv_title)
        val singer = itemView.findViewById<TextView>(R.id.rv_singer)
    }

}
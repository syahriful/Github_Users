package com.syahriful.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardUserAdapter(private var listUser: ArrayList<User>) :
    RecyclerView.Adapter<CardUserAdapter.CardViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val lang = listUser[position]

        Glide.with(holder.itemView.context)
            .load(lang.avatar)
            .apply(RequestOptions().override(400,450))
            .into(holder.imgPhoto)

        holder.tvName.text = lang.name
        holder.tvUsername.text = lang.username
        holder.imgPhoto.setOnClickListener { onItemClickCallback.onItemClicked(listUser[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvUsername: TextView = itemView.findViewById(R.id.tv_username)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_avatar)
    }
}
package com.syahriful.githubusers

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.syahriful.githubusers.databinding.UserCardBinding

class CardUserAdapter(private var listUser: ArrayList<User>) : RecyclerView.Adapter<CardUserAdapter.CardViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = UserCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

    inner class CardViewHolder(private val binding: UserCardBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(data: User) {
            Glide.with(itemView)
                .load(data.avatar)
                .apply(RequestOptions().override(400,450))
                .into(binding.imgAvatar)

            binding.tvName.text = data.name
            binding.tvUsername.text = "@${data.username}"
            binding.tvFollowers.text = data.followers.toString()
            binding.tvFollowing.text = data.following.toString()

            itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(listUser[adapterPosition])
            }
        }
    }
}
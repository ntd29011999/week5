package com.example.android.firstweekchallenge.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.firstweekchallenge.R
import com.bumptech.glide.Glide

class RestaurantAdapter: ListAdapter<Restaurant, RestaurantAdapter.ViewHolder>(RestaurantDiffUtilCallback()){

    class RestaurantDiffUtilCallback : DiffUtil.ItemCallback<Restaurant>(){
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.address == newItem.address
        }
        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent) as ViewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var itemRestaurant = getItem(position)
        holder.bind(itemRestaurant)
    }

    class ViewHolder private constructor(val itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val txAddress = itemView.findViewById<TextView>(R.id.tvAddress)
        val imAvatar = itemView.findViewById<ImageView>(R.id.imageview)

        companion object {
            fun from(parent: ViewGroup) : RecyclerView.ViewHolder {
                var layoutInflater = LayoutInflater.from(parent.context)
                var view = layoutInflater.inflate(R.layout.restaurant_item_view, parent, false)
                return ViewHolder(view)
            }
        }
        fun bind(itemRestaurant: Restaurant) {
            tvName.text = itemRestaurant.name
            txAddress.text =itemRestaurant.address
            Glide.with(itemView).load(itemRestaurant.picturePath).into(imAvatar)
        }
    }
}



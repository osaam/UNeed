package com.osamaelsh3rawy.graduation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osamaelsh3rawy.graduation.data.model.FavItems
import com.osamaelsh3rawy.graduation.data.model.Items
import com.osamaelsh3rawy.graduation.databinding.ItemFavBinding

class FavAdapter(private val list: ArrayList<Items>,var favInterface: FavInterface) :
    RecyclerView.Adapter<FavAdapter.FavViewHolder>() {

    class FavViewHolder(val itemFavBinding: ItemFavBinding) : RecyclerView.ViewHolder(itemFavBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val binding = ItemFavBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        var data = list[position]
        holder.itemFavBinding.btnDisable.setOnClickListener(View.OnClickListener {
            favInterface.RemoveFav(data)
        })

        holder.itemFavBinding.cardFav.setOnClickListener(View.OnClickListener {
            favInterface.FavOnItemClicked(data)
        })

    }
    fun addData(lists: List<Items>) {
        list.addAll(lists)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size


    interface FavInterface {
        fun FavOnItemClicked(item: Items)
        fun RemoveFav(item: Items)
    }

    }

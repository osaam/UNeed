package com.osamaelsh3rawy.graduation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osamaelsh3rawy.graduation.data.model.Items
import com.osamaelsh3rawy.graduation.databinding.ItemProductBinding
import java.util.*

class ItemAdapter(val list: ArrayList<Items>, var homeInterface: HomeInterface) :
    RecyclerView.Adapter<ItemAdapter.VHhome>() {
    var Tag="ItemAdapter"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHhome {
        return VHhome(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false     )) }

    override fun getItemCount(): Int = list.size

    fun addData(listItem: List<Items>) {
        list.addAll(listItem)
        Log.d(Tag ,"num of list"+list.size)
    }

    override fun onBindViewHolder(holder: VHhome, position: Int) {
        var item: Items = list [position]
        holder.binding.item = item

        holder.binding.card.setOnClickListener(View.OnClickListener {
                homeInterface.OnItemClicked(item)
        })
        holder.binding.btnAdd.setOnClickListener(View.OnClickListener {
            homeInterface.addItemToCart(item)
        })
        holder.binding.btnFav.setOnClickListener(View.OnClickListener {
            homeInterface.addItemToFav(item)
        })

    }

    class VHhome(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        }

    interface HomeInterface {
        fun addItemToCart(item: Items)
        fun OnItemClicked(item: Items)
        fun addItemToFav(item: Items)
    }
}
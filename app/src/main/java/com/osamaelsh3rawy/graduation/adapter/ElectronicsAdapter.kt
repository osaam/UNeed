package com.osamaelsh3rawy.graduation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osamaelsh3rawy.graduation.data.model.Items
import com.osamaelsh3rawy.graduation.databinding.ItemProductBinding
import com.osamaelsh3rawy.graduation.databinding.ItemProductElecBinding
import java.util.*

class ElectronicsAdapter(val list: ArrayList<Items>, var homeInterface: ItemAdapter.HomeInterface) :
    RecyclerView.Adapter<ElectronicsAdapter.VHhome>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHhome {
        return VHhome(
            ItemProductElecBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int = list.size

    fun addData(listItem:List<Items>) {
        list.addAll(listItem)
    }

    override fun onBindViewHolder(holder: VHhome, position: Int) {
        var item: Items = list[position]
        holder.binding.item = item

        holder.binding.cardElec.setOnClickListener(View.OnClickListener {
                homeInterface.OnItemClicked(item)
        })
        holder.binding.btnAddElec.setOnClickListener(View.OnClickListener {
            homeInterface.addItemToCart(item)
        })
        holder.binding.btnFavElec.setOnClickListener(View.OnClickListener {
            homeInterface.addItemToFav(item)
        })

    }

    class VHhome(val binding: ItemProductElecBinding) : RecyclerView.ViewHolder(binding.root) {
        }

}
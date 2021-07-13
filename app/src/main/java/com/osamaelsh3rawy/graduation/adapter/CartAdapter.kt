package com.osamaelsh3rawy.graduation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.os.persistableBundleOf
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.osamaelsh3rawy.graduation.data.model.CartItems
import com.osamaelsh3rawy.graduation.databinding.ItemCartBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class CartAdapter
constructor(val list: ArrayList<CartItems>, var cartInterface: CartInterface) :
    RecyclerView.Adapter<CartAdapter.VHCartAdapter>() {
    var TAG="Cart Adapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHCartAdapter {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding = ItemCartBinding.inflate(
            layoutInflater,
            parent,
            false)
        return VHCartAdapter(binding) }

    override fun getItemCount(): Int = list.size


    fun addData(lists: List<CartItems>) {
        list.addAll(lists)
        Log.d(TAG ,"num of list"+list.size)
    }


    override fun onBindViewHolder(holder: VHCartAdapter, position: Int) {
        var item: CartItems = list[position]
        holder.itemview.cartItem = item
        holder.itemview.executePendingBindings()

//        holder.itemview.remove.setOnClickListener(View.OnClickListener {
//            cartInterface.deleteitem(item)
//            notifyDataSetChanged()
//        })
//
//        holder.itemview.sppItemCart.onItemSelectedListener =
//            object : AdapterView.OnItemSelectedListener {
//                override fun onNothingSelected(parent: AdapterView<*>?) {}
//                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
//                ) {
//                    var quantity = position + 1
//                    if (quantity == item.count) {
//                        return
//                    }
//                    cartInterface.changeQuantity(item, quantity)
//                    notifyDataSetChanged() } }
    }



    class VHCartAdapter(val itemview: ItemCartBinding) :
        RecyclerView.ViewHolder(itemview.root) {

    }
    interface CartInterface {
        fun deleteitem(cartItem: CartItems)
        fun changeQuantity(cartItem: CartItems, quantity: Int)
    }

}

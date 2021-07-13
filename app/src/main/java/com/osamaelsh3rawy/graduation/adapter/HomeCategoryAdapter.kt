package com.osamaelsh3rawy.graduation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.data.model.CategoryItems
import com.osamaelsh3rawy.graduation.data.model.Items
import com.osamaelsh3rawy.graduation.databinding.ItemCategoryBinding
import com.osamaelsh3rawy.graduation.ui.fragment.home.HomeViewModel

class HomeCategoryAdapter(val categoryList: ArrayList<CategoryItems>) :
    RecyclerView.Adapter<HomeCategoryAdapter.HomeCatViewHolder>() {

    lateinit var itemList: ArrayList<Items>
    lateinit var homeInterface:ItemAdapter.HomeInterface


    class HomeCatViewHolder(val itemview: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itemview.root) {
            lateinit var itemAdapter: ItemAdapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCatViewHolder {
        var binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeCatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeCatViewHolder, position: Int) {
        var data: CategoryItems = categoryList[position]
//        holder.itemview.txtCategoryName.text=data.cat
//
//        holder.itemAdapter= ItemAdapter(itemList,homeInterface)
//        holder.itemview.rcCategory.adapter=holder.itemAdapter

    }

    override fun getItemCount(): Int = categoryList.size



//
//    override fun addItemToCart(item: Items) {
//        var isAdded=homeViewModel.addItemToCart(item)
//        if(isAdded){
//            Snackbar.make(requireView(),item.name+"added to cart" , Snackbar.LENGTH_SHORT)
//                .setAction("Check Out" , View.OnClickListener {
//                    navController.navigate(R.id.fragmentCart)
//                }).show()
//        }
//        else{
//            Snackbar.make(requireView(),"Already have the max quantity", Snackbar.LENGTH_SHORT)
//                .show() } }
//
//    override fun OnItemClicked(item: Items) {
//        homeViewModel.setDataToDetaiels(item)
//        navController.navigate(R.id.home_to_Details)
//    }
//
//    override fun addItemToFav(item: Items) {
//        homeViewModel.addItemToFav(item)
//    }
}
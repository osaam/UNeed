package com.osamaelsh3rawy.graduation.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.adapter.FavAdapter
import com.osamaelsh3rawy.graduation.data.model.Items
import com.osamaelsh3rawy.graduation.databinding.FragmentFavBinding
import com.osamaelsh3rawy.graduation.ui.activity.BaseFragment
import com.osamaelsh3rawy.graduation.ui.activity.HomeActivity

class FragmentFav : BaseFragment(), FavAdapter.FavInterface {
    private lateinit var favBinding: FragmentFavBinding
    private lateinit var navController: NavController
    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_fav, container, false)
        favBinding.lifecycleOwner = this

//        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel=HomeActivity.homeViewModel
        setUpRecycler()
        homeActivity.loginCycleVisibility(View.VISIBLE)
        return favBinding.root
    }

    private fun setUpRecycler() {
        var favAdapter = FavAdapter(arrayListOf(),this)
        favBinding.favRecycler.adapter = favAdapter
        homeViewModel.getFav().observe(viewLifecycleOwner, Observer {
            favAdapter.addData(it)
            favAdapter.notifyDataSetChanged()
        })

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
    }

    override fun FavOnItemClicked(item: Items) {
        homeViewModel.setProduct(item)
        navController.navigate(R.id.home_to_Details)
    }

    override fun RemoveFav(item: Items) {
        homeViewModel.RemoveItemFromFav(item)
    }
}
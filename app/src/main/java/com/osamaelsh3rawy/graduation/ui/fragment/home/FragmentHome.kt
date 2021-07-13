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
import com.google.android.material.snackbar.Snackbar
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.adapter.ClothesAdapter
import com.osamaelsh3rawy.graduation.adapter.ElectronicsAdapter
import com.osamaelsh3rawy.graduation.adapter.ItemAdapter
import com.osamaelsh3rawy.graduation.adapter.MarketAdapter
import com.osamaelsh3rawy.graduation.data.model.Items
import com.osamaelsh3rawy.graduation.databinding.FragmentHomeBinding
import com.osamaelsh3rawy.graduation.ui.activity.BaseFragment

class FragmentHome : BaseFragment(), ItemAdapter.HomeInterface {
    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var clothesAdapter: ClothesAdapter
    private lateinit var marketAdapter: MarketAdapter
    private lateinit var elecAdapter: ElectronicsAdapter

        lateinit var homeViewModel: HomeViewModel


    lateinit var navController: NavController

    var TAG = "FragmentHome"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_home,
                container,
                false
            )
        homeBinding.lifecycleOwner = this
        homeActivity.loginCycleVisibility(View.VISIBLE)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeItems()
        navController = Navigation.findNavController(view)
    }

    private fun homeItems() {

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        itemAdapter = ItemAdapter(arrayListOf(), this)
        homeBinding.rvPopular.adapter = itemAdapter
        homeViewModel.getAllItems().observe(viewLifecycleOwner, Observer {
            itemAdapter.addData(it)
        })

        clothesAdapter = ClothesAdapter(arrayListOf(), this)
        homeBinding.rvClothes.adapter = clothesAdapter
        homeViewModel.getAllClothes().observe(viewLifecycleOwner, Observer {
            clothesAdapter.addData(it)
        })

        marketAdapter = MarketAdapter(arrayListOf(), this)
        homeBinding.rvmarket.adapter = marketAdapter
        homeViewModel.getAllMarket().observe(viewLifecycleOwner, Observer {
            marketAdapter.addData(it)
        })


        elecAdapter = ElectronicsAdapter(arrayListOf(), this)
        homeBinding.rvElectronics.adapter = elecAdapter
        homeViewModel.getAllElectronics().observe(viewLifecycleOwner, Observer {
            elecAdapter.addData(it)
        })


    }

    override fun addItemToCart(item: Items) {
        var isAdded = homeViewModel.addItemToCart(item)

        if (isAdded) {
            Snackbar.make(requireView(), item.name + "    added to cart", Snackbar.LENGTH_SHORT)
                .setAction("Check Out", View.OnClickListener {
                    navController.navigate(R.id.fragmentCart)
                }).show()
        } else {
            Snackbar.make(requireView(), "Already have the max quantity", Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    override fun OnItemClicked(item: Items) {
        homeViewModel.setProduct(item)
        navController.navigate(R.id.home_to_Details)
    }

    override fun addItemToFav(item: Items) {
        var isAdded = homeViewModel.addItemToFav(item)

        if (isAdded != null) {
            Snackbar.make(requireView(), item.name + "   added to favourit", Snackbar.LENGTH_SHORT)
                .setAction("Check Out", View.OnClickListener {
                    navController.navigate(R.id.fragmentFav)
                }).show()
        } else {
            Snackbar.make(requireView(), "Already you have it in favourit", Snackbar.LENGTH_SHORT)
                .show()
        }
    }

}

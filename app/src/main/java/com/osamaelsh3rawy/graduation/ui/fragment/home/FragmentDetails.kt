package com.osamaelsh3rawy.graduation.ui.fragment.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.data.model.Items
import com.osamaelsh3rawy.graduation.databinding.FragmentDetailsBinding
import com.osamaelsh3rawy.graduation.ui.activity.BaseFragment
import com.osamaelsh3rawy.graduation.ui.activity.HomeActivity


class FragmentDetails : BaseFragment() {
    lateinit var DetailsBinding: FragmentDetailsBinding
    lateinit var homeViewModel: HomeViewModel
    private var TAG ="FragmentDetails"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DetailsBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_details,
                container,
                false
            )
        DetailsBinding.lifecycleOwner = this
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        DetailsBinding.homeViewModel = homeViewModel

        homeActivity.loginCycleVisibility(View.VISIBLE)

        return DetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var product:LiveData<Items> = homeViewModel.getProduct()
        Log.d(TAG,"num of detaiels item "+product.value)
        DetailsBinding.btnAddtocart.setOnClickListener(View.OnClickListener {
            product?.let {
                homeViewModel.addItemToCart(it.value!!)
            }
        })
    }

}
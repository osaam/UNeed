package com.osamaelsh3rawy.graduation.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.databinding.FragmentDetailsBinding


class FragmentDetails : Fragment() {
lateinit var DetailsBinding: FragmentDetailsBinding
    lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DetailsBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_details,
                container,
                false)

        return DetailsBinding.root }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel= ViewModelProvider(this).get(HomeViewModel::class.java)
        DetailsBinding.homeViewModel=homeViewModel
    }
}
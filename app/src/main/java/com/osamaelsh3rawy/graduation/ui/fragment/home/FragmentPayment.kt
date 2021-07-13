package com.osamaelsh3rawy.graduation.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.databinding.FragmentPaymentBinding
import com.osamaelsh3rawy.graduation.databinding.FragmentSupportBinding
import com.osamaelsh3rawy.graduation.ui.activity.BaseFragment
import com.osamaelsh3rawy.graduation.ui.activity.HomeActivity
import kotlinx.android.synthetic.main.activity_home.*

class FragmentPayment : BaseFragment() {
    private lateinit var paymentBinding: FragmentPaymentBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        paymentBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_payment,
                container,
                false
            )

        homeActivity.loginCycleVisibility(View.VISIBLE)

        return paymentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(view)
        paymentBinding.buynow.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.payment_to_Credit)
        })

    }

}
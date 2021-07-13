package com.osamaelsh3rawy.graduation.ui.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.osamaelsh3rawy.graduation.R
import com.osamaelsh3rawy.graduation.adapter.CartAdapter
import com.osamaelsh3rawy.graduation.adapter.ClothesAdapter
import com.osamaelsh3rawy.graduation.adapter.ItemAdapter
import com.osamaelsh3rawy.graduation.data.model.CartItems
import com.osamaelsh3rawy.graduation.databinding.FragmentCartBinding
import com.osamaelsh3rawy.graduation.ui.activity.BaseFragment
import com.osamaelsh3rawy.graduation.ui.activity.HomeActivity

class FragmentCart : BaseFragment(), CartAdapter.CartInterface {

    private lateinit var cartBinding: FragmentCartBinding
    lateinit var cartAdapter: CartAdapter
    var TAG="FragmentCart"
    companion object{
    lateinit var homeViewModel: HomeViewModel}
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        homeActivity.loginCycleVisibility(View.VISIBLE)
        return cartBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
     // homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel=HomeActivity.homeViewModel

        homeViewModel.getCart().observe( viewLifecycleOwner,Observer {
            Log.d(TAG, " num onChanged: " + it.size)
        })
        cart()

    }

    private fun cart() {
        cartAdapter = CartAdapter(arrayListOf(), this)
        cartBinding.rcCart.adapter = cartAdapter
        homeViewModel.getCart().observe(viewLifecycleOwner, Observer {
            cartAdapter.addData(it)
            cartBinding.btnBuynow.isEnabled
            cartAdapter.notifyDataSetChanged()
            // cartBinding.btnBuynow.isEnabled = it.isNotEmpty()
        })

        homeViewModel.totalPrice().observe(viewLifecycleOwner, Observer {
            cartBinding.total.text = "ToTal $ $it"
        })
        cartBinding.btnBuynow.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.Cart_to_payment)
        })
    }

    override fun deleteitem(cartItem: CartItems) {
        homeViewModel.removeItemFromCart(cartItem)
    }

    override fun changeQuantity(cartItem: CartItems, quantity: Int) {
        homeViewModel.changeQuantity(cartItem, quantity)
    }
}
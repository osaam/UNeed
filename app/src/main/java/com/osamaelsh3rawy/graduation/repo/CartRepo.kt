package com.osamaelsh3rawy.graduation.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.osamaelsh3rawy.graduation.data.model.CartItems
import com.osamaelsh3rawy.graduation.data.model.Items
import java.util.*
import kotlin.collections.ArrayList


class CartRepo {
    var mutableCart = MutableLiveData<List<CartItems>>()
    var total = MutableLiveData<Double>()
    var tag = "CartRepo"
    fun getCart(): LiveData<List<CartItems>> {
        if (mutableCart.value == null) {
            initCart()
        }
        return mutableCart
    }

    private fun initCart() {
        mutableCart.value = ArrayList<CartItems>()
        totalPrice()
    }

    fun addItemToCart(item: Items): Boolean {
        if (mutableCart.value == null) {
            initCart()
        }
        var cartlist = ArrayList<CartItems>()
        cartlist = mutableCart.value as ArrayList<CartItems>
        for (cartitem in cartlist) {
            if (cartitem.item.id == item.id) {
                if (cartitem.count == 5) {
                    return false }
                val index = cartlist.indexOf(cartitem)
                cartitem.count = cartitem.count + 1
                cartlist[index] = cartitem
                mutableCart.value = cartlist
                totalPrice() } }
        var cartItem = CartItems(1, item)
        cartlist.add(cartItem)
        mutableCart.value = cartlist
        Log.d(tag,"num of product"+mutableCart.value)
        totalPrice()
        return true
    }

    fun removeItemToCart(item: CartItems): Boolean {
        if (mutableCart.value == null) {
            return false
        }
        var list: ArrayList<CartItems> = mutableCart.value as ArrayList<CartItems>
        list.remove(item)
        mutableCart.value = list
        totalPrice()
        return true
    }

    fun changeQuantity(cartItems: CartItems, quantity: Int) {
        if (mutableCart.value == null) {
            return
        }
        // var list: List<CartItems> = ArrayList<CartItems>(mutableCart.value)
        var list: ArrayList<CartItems> = mutableCart.value as ArrayList<CartItems>
        var update = CartItems(quantity, cartItems.item)
        list[list.indexOf(cartItems)] = update
        mutableCart.value = list
        totalPrice()
    }

    fun totalPrice(): LiveData<Double> {
        if (mutableCart.value == null) {
            total.value = (0).toDouble()
            return total
        }
        var D = 0.0

        var list: ArrayList<CartItems> = mutableCart.value as ArrayList<CartItems>
        for (item in list) {
            D = (item.item.price.toDouble() * item.count.toDouble())
        }
        total.value = D
        return total
    }


}
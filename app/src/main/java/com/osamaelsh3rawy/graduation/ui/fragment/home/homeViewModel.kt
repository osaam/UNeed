package com.osamaelsh3rawy.graduation.ui.fragment.home

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.osamaelsh3rawy.graduation.data.model.CartItems
import com.osamaelsh3rawy.graduation.data.model.FavItems
import com.osamaelsh3rawy.graduation.data.model.Items
import com.osamaelsh3rawy.graduation.repo.CartRepo
import com.osamaelsh3rawy.graduation.repo.FavRepo
import com.osamaelsh3rawy.graduation.repo.ShopRepo

class HomeViewModel : ViewModel() {

    val cartRepo =  CartRepo()
    val shopRepo = ShopRepo()
    val favRepo = FavRepo()

    var dataDetails:MutableLiveData<Items> = MutableLiveData()

    fun getAllItems(): LiveData<List<Items>> {
        return shopRepo.getItems
    }

    fun setProduct(item: Items) {
        dataDetails.value=item
    }
    fun getProduct(): LiveData<Items> {
        return  dataDetails
    }

    fun getAllClothes(): LiveData<List<Items>> {
        return shopRepo.getItemsClothes
    }

    fun getAllElectronics(): LiveData<List<Items>> {
        return shopRepo.getItemsElec
    }

    fun getAllMarket(): LiveData<List<Items>> {
        return shopRepo.getItemsMarket
    }

    fun getFav(): LiveData<List<Items>> {
        return favRepo.getFav()
    }

    fun getCart(): LiveData<List<CartItems>> {
        return cartRepo.getCart()
    }

    fun addItemToCart(item: Items): Boolean {
        return cartRepo.addItemToCart(item)
    }

    fun removeItemFromCart(itemcart: CartItems): Boolean {
        return cartRepo.removeItemToCart(itemcart)
    }

    fun changeQuantity(cartItems: CartItems, quantity: Int) {
        cartRepo.changeQuantity(cartItems, quantity)
    }

    fun totalPrice(): LiveData<Double> {
        return cartRepo.totalPrice()
    }

    fun addItemToFav(item: Items) {
        favRepo.addItemToFav(item)
    }

    fun RemoveItemFromFav(item: Items) {
        favRepo.removeItemFromFav(item)
    }
}

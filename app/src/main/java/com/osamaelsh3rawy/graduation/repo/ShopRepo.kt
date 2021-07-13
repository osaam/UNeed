package com.osamaelsh3rawy.graduation.repo

import androidx.lifecycle.MutableLiveData
import com.osamaelsh3rawy.graduation.data.model.Items
import com.osamaelsh3rawy.graduation.data.model.constant
import java.util.*

class ShopRepo {
    var mutableItemList = MutableLiveData<List<Items>>()
    val getItems: MutableLiveData<List<Items>>
        get() {
            loadItems()
            return mutableItemList
        }

    private fun loadItems() {
        var Itemsdata = ArrayList<Items>()
        Itemsdata = constant.getItems()
        mutableItemList.value = Itemsdata
    }

    var mutableItemListClothes = MutableLiveData<List<Items>>()
    val getItemsClothes: MutableLiveData<List<Items>>
        get() {
            loadItemsClothes()
            return mutableItemListClothes
        }

    private fun loadItemsClothes() {
        var Itemsdata = ArrayList<Items>()
        Itemsdata = constant.getclothes()
        mutableItemListClothes.value = Itemsdata
    }

    var mutableItemListElec = MutableLiveData<List<Items>>()
    val getItemsElec: MutableLiveData<List<Items>>
        get() {
            loadItemsElec()
            return mutableItemListElec
        }

    private fun loadItemsElec() {
        var Itemsdata = ArrayList<Items>()
        Itemsdata = constant.getelectronics()
        mutableItemListElec.value = Itemsdata
    }

    var mutableItemListMarket = MutableLiveData<List<Items>>()
    val getItemsMarket: MutableLiveData<List<Items>>
        get() {
            loadItemsMarket()
            return mutableItemListMarket
        }

    private fun loadItemsMarket() {
        var Itemsdata = ArrayList<Items>()
        Itemsdata = constant.getmarket()
        mutableItemListMarket.value = Itemsdata
    }



}
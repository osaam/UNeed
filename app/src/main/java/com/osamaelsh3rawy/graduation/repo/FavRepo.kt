package com.osamaelsh3rawy.graduation.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.osamaelsh3rawy.graduation.data.model.CartItems
import com.osamaelsh3rawy.graduation.data.model.FavItems
import com.osamaelsh3rawy.graduation.data.model.Items

class FavRepo {
    val mutableFav = MutableLiveData<List<Items>>()
    fun getFav(): MutableLiveData<List<Items>> {
        if (mutableFav.value == null) {
            initFav()
        }
        return mutableFav
    }

    private fun initFav() {
        mutableFav.value = arrayListOf()
    }

    fun addItemToFav(item: Items) {
        if (mutableFav.value == null) {
            initFav()
        }
        var favList = ArrayList<Items>()
        favList = mutableFav.value as ArrayList<Items>
        for (list in favList) {
            if (list.id == item.id) {
                break
            } else {
                var favitem = item
                favList.add(favitem)
                mutableFav.value = favList
            }
        }
    }

    fun removeItemFromFav(item: Items) {
        var favList = ArrayList<Items>()
        favList = mutableFav.value as ArrayList<Items>
        var favitem = item
        favList.remove(favitem)
        mutableFav.value = favList

    }


}
package com.osamaelsh3rawy.graduation.data.model

import android.widget.Spinner
import androidx.databinding.BindingAdapter

data class CartItems(
    var count: Int,
    val item: Items
)

@BindingAdapter("setQuantatiy")
fun setQuantatiy(sp: Spinner, quantatiy: Int) {
    sp.setSelection(quantatiy - 1, true)
}

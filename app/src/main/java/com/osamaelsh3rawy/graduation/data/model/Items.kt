package com.osamaelsh3rawy.graduation.data.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.item_product.view.*
import com.bumptech.glide.Glide.with as with

data class Items(
    var id: Int,
    val name: String,
    val price: Int,
    val categortId: String,
    val imageUrl: Int,
    val description: String,
    val isFav: Boolean
) {
}

@BindingAdapter("android:loadImage")
fun ImageView.loadImage(image: Int) {
        Glide.with(this)
        .load(image)
        .fitCenter()
        .into(this)
}


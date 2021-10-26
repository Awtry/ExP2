package com.awtry.exp2.core.extension

import android.media.Image
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.awtry.exp2.R

@BindingAdapter("loadFromUrl")
fun ImageView.loadFromUrl(url: String) = this.load(url){
    crossfade(true)
    placeholder(R.drawable.ic_food)
}
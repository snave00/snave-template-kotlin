package com.pnb.android.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.evansontemplate.R

fun AppCompatImageView.loadImageInt(drawbale: Int?, context: Context) {
    Glide.with(context)
        .load(drawbale)
        .placeholder(ContextCompat.getDrawable(context, R.color.white))
        .error(ContextCompat.getDrawable(context, R.color.white))
        .transition(DrawableTransitionOptions.withCrossFade())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

fun AppCompatImageView.loadImageIntCenterCrop(drawbale: Int?, context: Context) {
    Glide.with(context)
        .load(drawbale)
        .centerCrop()
        .placeholder(ContextCompat.getDrawable(context, R.color.white))
        .error(ContextCompat.getDrawable(context, R.color.white))
        .transition(DrawableTransitionOptions.withCrossFade())
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

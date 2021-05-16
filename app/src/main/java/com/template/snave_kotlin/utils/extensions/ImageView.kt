package com.pnb.android.extensions

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.template.snave_kotlin.R

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

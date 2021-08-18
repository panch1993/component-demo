package com.pans.libbase.extension

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.File

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:
 */
object ImageExtension {
    var i = 1
}

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).into(this)
}

fun ImageView.loadImage(file: File) {
    Glide.with(this).load(file).into(this)
}

fun ImageView.loadImage(bitmap: Bitmap) {
    Glide.with(this).load(bitmap).into(this)
}

fun ImageView.loadImage(drawable: Drawable) {
    Glide.with(this).load(drawable).into(this)
}
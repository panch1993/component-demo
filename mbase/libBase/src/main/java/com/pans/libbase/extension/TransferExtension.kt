package com.pans.libbase.extension

import android.content.res.Resources

/**
 * Create by panchenhuan on 8/18/21
 * walkwindc8@foxmail.com
 * Description:单位转换
 */


fun Int.dp2px(): Int {
    val scale = Resources.getSystem().displayMetrics.density
    return (this * scale + 0.5f).toInt()
}

fun Int.px2dp(): Int {
    val scale = Resources.getSystem().displayMetrics.density
    return (this / scale + 0.5f).toInt()
}

fun Int.sp2px(): Int {
    val fontScale = Resources.getSystem().displayMetrics.scaledDensity
    return (this * fontScale + 0.5f).toInt()
}

fun Int.px2sp(): Int {
    val fontScale = Resources.getSystem().displayMetrics.scaledDensity
    return (this / fontScale + 0.5f).toInt()
}
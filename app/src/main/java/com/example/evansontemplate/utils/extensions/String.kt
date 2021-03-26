package com.example.evansontemplate.utils.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.*
import android.text.style.LeadingMarginSpan
import android.util.DisplayMetrics
import android.util.Log
import android.util.Patterns
import androidx.core.content.res.ResourcesCompat
import com.google.gson.GsonBuilder
import retrofit2.HttpException
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*


fun getDeviceDensityString(context: Context): String {
    return when (context.resources.displayMetrics.densityDpi) {
        DisplayMetrics.DENSITY_LOW -> "ldpi"
        DisplayMetrics.DENSITY_MEDIUM -> "mdpi"
        DisplayMetrics.DENSITY_TV, DisplayMetrics.DENSITY_HIGH -> "hdpi"
        DisplayMetrics.DENSITY_260, DisplayMetrics.DENSITY_280, DisplayMetrics.DENSITY_300, DisplayMetrics.DENSITY_XHIGH -> "xhdpi"
        DisplayMetrics.DENSITY_340, DisplayMetrics.DENSITY_360, DisplayMetrics.DENSITY_400, DisplayMetrics.DENSITY_420, DisplayMetrics.DENSITY_440, DisplayMetrics.DENSITY_XXHIGH -> "xxhdpi"
        DisplayMetrics.DENSITY_560, DisplayMetrics.DENSITY_XXXHIGH -> "xxxhdpi"
        else -> "not found"
    }
}

inline fun SpannableStringBuilder.withSpan(span: Any, action: SpannableStringBuilder.() -> Unit): SpannableStringBuilder {
    val from = length
    action()
    setSpan(span, from, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    return this
}

/**
 * Format the string to the needed proper date
 */
fun stringFormatter(dateString: String, outputFormat: String): String {
    val format = SimpleDateFormat("yyyy-MM-dd hh:mm aa")
    format.timeZone=TimeZone.getTimeZone("GMT+0")
    val date: Date = format.parse(dateString)

    val dateFormat =
        SimpleDateFormat(outputFormat, Locale.getDefault())
    dateFormat.timeZone= TimeZone.getTimeZone("GMT+8")
    val dateTime = dateFormat.format(date)

    return dateTime.toUpperCase()
}

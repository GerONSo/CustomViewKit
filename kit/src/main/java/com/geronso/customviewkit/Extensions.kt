package com.geronso.customviewkit

import android.view.View
import androidx.annotation.ColorRes

fun View.color(@ColorRes color: Int) : Int {
    return resources.getColor(color, context.theme)
}
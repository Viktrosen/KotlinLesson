package com.hfrad.kotlinlesson.extensions

import android.view.View
import com.hfrad.kotlinlesson.extensions.dip

inline fun View.dip(value: Int) = context.dip(value)

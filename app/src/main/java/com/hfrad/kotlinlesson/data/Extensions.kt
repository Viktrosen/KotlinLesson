package com.hfrad.kotlinlesson.data

import android.content.Context
import androidx.core.content.ContextCompat
import com.hfrad.kotlinlesson.R
import com.hfrad.kotlinlesson.data.entity.Note
import java.text.SimpleDateFormat
import java.util.*

const val DATE_TIME_FORMAT = "dd.MMM.yy HH:mm"

fun Date.format(): String =
        SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault())
                .format(this)

fun Note.Color.getColorInt(context: Context): Int =
        ContextCompat.getColor(context, when (this) {
            Note.Color.WHITE -> R.color.white
            Note.Color.VIOLET -> R.color.violet
            Note.Color.YELLOW -> R.color.yellow
            Note.Color.RED -> R.color.red
            Note.Color.PINK -> R.color.pink
            Note.Color.GREEN -> R.color.green

        })
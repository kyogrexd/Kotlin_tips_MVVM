package com.example.kotlin_tips_mvvm.helper

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.equals(with: Calendar, type: Int) = get(type) == with.get(type)

fun Calendar.format(format: String): String =
    SimpleDateFormat(format, Locale.getDefault()).format(this.time)
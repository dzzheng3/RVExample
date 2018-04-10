package com.example.dz.rvdemo.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

class DateUtil{
    companion object {
        private var simpleFormatter = SimpleDateFormat("HH-mm-ss", Locale.US)
        fun getStringFromDate(date:Date): String {
            return simpleFormatter.format(date)
        }
    }
}
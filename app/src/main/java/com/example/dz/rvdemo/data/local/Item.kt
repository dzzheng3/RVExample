package com.example.dz.rvdemo.data.local

import android.text.format.DateUtils
import com.example.dz.rvdemo.util.DateUtil
import java.util.*

data class Item(var name: String, var date: Date) {
    fun getDateString(): String {
        return DateUtil.getStringFromDate(date) as String
    }
}
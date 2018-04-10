package com.example.dz.rvdemo.data

import com.example.dz.rvdemo.data.local.Item
import com.example.dz.rvdemo.util.DateUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.TimeUnit

class DataManager {
    fun getItemList(): List<Item> {
        var list = mutableListOf<Item>()

        for (i in 0..5) {
            list.add(Item("test" + i, DateUtil.getStringFromDate(Date())))
        }
        return list
    }
}
package com.example.dz.rvdemo.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bumptech.glide.Glide.init
import com.example.dz.rvdemo.data.DataManager
import com.example.dz.rvdemo.data.local.Item
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel() {
    private var liveData = MutableLiveData<List<Item>>()
    private var dataManager = DataManager()

    init {
        Observable.interval(2, TimeUnit.SECONDS)
                .take(5)
                .map { v -> v + 1 }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    liveData.postValue(dataManager.getItemList())
                }

    }

    fun getItemList(): LiveData<List<Item>> {
        return liveData
    }
}
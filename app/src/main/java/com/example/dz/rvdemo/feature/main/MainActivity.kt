package com.example.dz.rvdemo.feature.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.dz.rvdemo.R
import com.example.dz.rvdemo.databinding.ActivityMainBinding
import com.example.dz.rvdemo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var  mainAdapter:MainAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        mainBinding.setLifecycleOwner(this)
        rv.layoutManager = LinearLayoutManager(this)
        mainAdapter = MainAdapter()
        rv.adapter = mainAdapter
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.getItemList().observe(this, Observer {
            mainAdapter?.setItemList(it!!)
            mainAdapter?.notifyDataSetChanged()
        })
    }
}

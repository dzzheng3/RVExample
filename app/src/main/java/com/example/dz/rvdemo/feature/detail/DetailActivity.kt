package com.example.dz.rvdemo.feature.detail

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.dz.rvdemo.R
import com.example.dz.rvdemo.data.local.Item
import com.example.dz.rvdemo.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        var ITEM_TAG = "item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailBinding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        val item = intent.getParcelableExtra<Item>(ITEM_TAG)
        if (item != null)
            detailBinding.item = item
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

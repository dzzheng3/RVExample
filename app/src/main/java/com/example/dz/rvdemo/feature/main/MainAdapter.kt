package com.example.dz.rvdemo.feature.main

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dz.rvdemo.R
import com.example.dz.rvdemo.data.local.Item
import com.example.dz.rvdemo.databinding.ItemMainBinding

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemList = mutableListOf<Item>()
    private var NORMALTYPE = 0
    private var DATETYPE = 1
    fun setItemList(list: List<Item>) {
        this.itemList.addAll(list)
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return DATETYPE
        }
        if (itemList.get(position - 1).date.equals(itemList.get(position).date)) {
            return NORMALTYPE
        } else {
            return DATETYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var itemMainBinding: ViewDataBinding? = null
        if (viewType == DATETYPE) {
            itemMainBinding = DataBindingUtil.inflate<ItemMainBinding>(LayoutInflater.from(parent.context), R.layout.item_main_data, parent, false)
        } else {
            itemMainBinding = DataBindingUtil.inflate<ItemMainBinding>(LayoutInflater.from(parent.context), R.layout.item_main, parent, false)
        }
        return MainViewHolder(itemMainBinding,onClickItemListener)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MainViewHolder)
            holder.bind(itemList.get(position))
    }

    interface OnClickItemListener {
        fun onClickItem(item: Item)
    }

    private var onClickItemListener: OnClickItemListener? = null
    fun setOnClickItemListener(onClickItemListener: OnClickItemListener) {
        this.onClickItemListener = onClickItemListener
    }
}
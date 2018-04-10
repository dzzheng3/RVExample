package com.example.dz.rvdemo.feature.main

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.example.dz.rvdemo.BR
import com.example.dz.rvdemo.data.local.Item

open class MainViewHolder(open var viewDataBinding: ViewDataBinding, var onClickItemListener: MainAdapter.OnClickItemListener?) : RecyclerView.ViewHolder(viewDataBinding.root) {
    open fun bind(item: Item) {
        viewDataBinding.setVariable(BR.item, item)
        viewDataBinding.executePendingBindings()
        viewDataBinding.root.setOnClickListener({
            if (onClickItemListener != null)
                onClickItemListener?.onClickItem(item)
        })
    }
}
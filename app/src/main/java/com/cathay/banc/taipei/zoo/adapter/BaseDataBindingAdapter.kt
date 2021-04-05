package com.cathay.banc.taipei.zoo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.cathay.banc.taipei.zoo.BR
import com.cathay.banc.taipei.zoo.entity.CommonItem

abstract class BaseDataBindingAdapter : RecyclerView.Adapter<BaseDataBindingAdapter.ViewHolder>() {

    inner class ViewHolder(val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {
        fun bind(obj: Any) {
            viewDataBinding.setVariable(BR.commonItem, obj)
            viewDataBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val viewDataBinding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), parent, false)
        return ViewHolder(viewDataBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val data = getDataAtPosition(position)
        //
        viewHolder.bind(data)
        //
        setOnClickLnr(viewHolder.viewDataBinding.root, data)
    }

    abstract fun getDataAtPosition(position: Int): Any
    abstract fun getLayoutId(): Int
    abstract fun setOnClickLnr(view: View, data: Any)
}

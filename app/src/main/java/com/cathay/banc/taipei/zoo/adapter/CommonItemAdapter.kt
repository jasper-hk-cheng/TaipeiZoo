package com.cathay.banc.taipei.zoo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.entity.CommonItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_plant.view.*

abstract class CommonItemAdapter(
    private val commonItemList: List<CommonItem>,
) : RecyclerView.Adapter<CommonItemAdapter.ViewHolder>() {

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val ivAvatar: ImageView = view.findViewById(R.id.ivAvatar)
        private val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        private val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        private val tvInfo: TextView = view.findViewById(R.id.tvInfo)

        fun bind(commonItem: CommonItem) {
            Picasso.with(view.context).load(commonItem.getAvatarUrl()).into(ivAvatar)
            tvTitle.text = commonItem.getTitle()
            tvDescription.text = commonItem.getDescription()
            tvInfo.text = commonItem.getInfo()
        }
    }

    override fun getItemCount(): Int = commonItemList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_arena_plant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val commonItem: CommonItem = commonItemList[position]
        //
        viewHolder.bind(commonItem)
        //
        setOnItemClickLnr(viewHolder.view, commonItem)
    }

    abstract fun setOnItemClickLnr(view: View, commonItem: CommonItem)
}

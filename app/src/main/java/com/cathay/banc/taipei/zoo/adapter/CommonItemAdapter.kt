package com.cathay.banc.taipei.zoo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.entity.CommonItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_plant.view.*

class CommonItemAdapter(
    private val commonItemList: List<CommonItem>,
) : BaseAdapter() {

    override fun getCount(): Int = commonItemList.count()
    override fun getItem(position: Int): CommonItem = commonItemList[position]
    override fun getItemId(position: Int): Long = position.toLong()

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

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View? = convertView
        val viewHolder: RecyclerView.ViewHolder

        if (view == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_arena_plant, parent, false)
            viewHolder = ViewHolder(view)

            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }
        viewHolder.bind(getItem(position))

        return view!!
    }
}
package com.cathay.banc.taipei.zoo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.util.SquareTransformation
import com.squareup.picasso.Picasso

class PlantAdapter(
    private val plantList: List<Plant>,
) : BaseAdapter() {

    override fun getCount(): Int = plantList.count()
    override fun getItem(position: Int): Plant = plantList[position]
    override fun getItemId(position: Int): Long = position.toLong()

    private class ViewHolder {
        lateinit var ivAvatar: ImageView
        lateinit var tvTitle: TextView
        lateinit var tvDescription: TextView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View? = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_arena_plant, null)
            viewHolder = ViewHolder()

            viewHolder.ivAvatar = view.findViewById(R.id.ivAvatar)
            viewHolder.tvTitle = view.findViewById(R.id.tvTitle)
            viewHolder.tvDescription = view.findViewById(R.id.tvDescription)

            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }
        val plant: Plant = getItem(position)

        Picasso.with(parent?.context).load(plant.avatarUrl).transform(SquareTransformation).into(viewHolder.ivAvatar)
        viewHolder.tvTitle.text = plant.nameCh
        viewHolder.tvDescription.text = plant.alias

        return view!!
    }
}

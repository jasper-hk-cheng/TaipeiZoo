package com.cathay.banc.taipei.zoo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.activity.PlantActivity
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.util.Constants
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_PLANT
import com.cathay.banc.taipei.zoo.util.SquareTransformation
import com.squareup.picasso.Picasso

class PlantAdapter(
    private val plantList: List<Plant>,
) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val ivAvatar: ImageView = view.findViewById(R.id.ivAvatar)
        private val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        private val tvDescription: TextView = view.findViewById(R.id.tvDescription)

        fun bind(plant: Plant) {
            Picasso.with(view.context).load(plant.avatarUrl).transform(SquareTransformation).into(ivAvatar)
            tvTitle.text = plant.nameCh
            tvDescription.text = plant.alias
        }
    }

    override fun getItemCount(): Int = plantList.count()

    /**
     *  viewType:Int
     *  from override fun getItemViewType(position:Position)
     *  used for multi-type view layout
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_arena_plant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val plant: Plant = plantList[position]
        //
        viewHolder.bind(plant)
        //
        viewHolder.view.setOnClickListener {
            val intent = Intent(it.context, PlantActivity::class.java)
            intent.putExtra(INTENT_EXTRA_KEY_PLANT, plant)
            it.context.startActivity(intent)
        }
    }
}

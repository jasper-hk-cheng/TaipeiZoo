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
import com.cathay.banc.taipei.zoo.activity.ArenaPlantFragmentActivity
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.util.CircleTransformation
import com.cathay.banc.taipei.zoo.util.Constants
import com.squareup.picasso.Picasso

class ArenaAdapter(
    private val arenaList: List<Arena>,
) : RecyclerView.Adapter<ArenaAdapter.ViewHolder>() {

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val ivAvatar: ImageView = view.findViewById(R.id.ivAvatar)
        private val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        private val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        private val tvInfo: TextView = view.findViewById(R.id.tvInfo)

        fun bind(arena: Arena) {
            Picasso.with(view.context).load(arena.avatarUrl).transform(CircleTransformation).into(ivAvatar)
            tvTitle.text = arena.title
            tvDescription.text = arena.description
            tvInfo.text = arena.info
        }
    }

    override fun getItemCount(): Int = arenaList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_arena_plant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val arena: Arena = arenaList[position]
        //
        viewHolder.bind(arena)
        //
        viewHolder.view.setOnClickListener {
            val intent = Intent(it.context, ArenaPlantFragmentActivity::class.java)
            intent.putExtra(Constants.INTENT_EXTRA_KEY_ARENA, arena)
            it.context.startActivity(intent)
        }
    }
}

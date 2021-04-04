package com.cathay.banc.taipei.zoo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.util.CircleTransformation
import com.squareup.picasso.Picasso

class ArenaAdapter(
    private val arenaList: List<Arena>,
) : BaseAdapter() {

    override fun getCount(): Int = arenaList.count()
    override fun getItem(position: Int): Arena = arenaList[position]
    override fun getItemId(position: Int): Long = position.toLong()

    private class ViewHolder {
        lateinit var ivAvatar: ImageView
        lateinit var tvTitle: TextView
        lateinit var tvDescription: TextView
        lateinit var tvInfo: TextView
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
            viewHolder.tvInfo = view.findViewById(R.id.tvInfo)

            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val arena: Arena = getItem(position)

        Picasso.with(parent?.context).load(arena.avatarUrl).transform(CircleTransformation).into(viewHolder.ivAvatar)
        viewHolder.tvTitle.text = arena.title
        viewHolder.tvDescription.text = arena.description
        viewHolder.tvInfo.text = arena.info

        return view!!
    }
}

/*
class ArenaAdapter(
    private val arenaList: List<Arena>,
) : RecyclerView.Adapter<ArenaAdapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val ivAvatar: ImageView = view.findViewById(R.id.ivAvatar)
        private val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        private val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        private val tvInfo: TextView = view.findViewById(R.id.tvInfo)

        fun bind(arena: Arena) {
            Picasso.with(view.context).load(arena.avatarUrl).into(ivAvatar)
            tvTitle.text = arena.title
            tvDescription.text = arena.description
            tvInfo.text = arena.info
        }
    }

    override fun getItemCount(): Int = arenaList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_arena_plant, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(arenaList[position])
    }
}
 */
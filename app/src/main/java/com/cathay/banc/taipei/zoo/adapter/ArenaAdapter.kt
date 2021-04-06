package com.cathay.banc.taipei.zoo.adapter

import android.content.Intent
import android.view.View
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.activity.ArenaPlantFragmentActivity
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.entity.CommonItem
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_ARENA

class ArenaAdapter(
    private val arenaList: List<Arena>,
) : BaseDataBindingAdapter() {
    override fun getDataAtPosition(position: Int): CommonItem = arenaList[position]
    override fun getLayoutId(): Int = R.layout.item_arena_plant
    override fun setOnClickLnr(view: View, data: Any) {
        view.setOnClickListener {
            val intent = Intent(it.context, ArenaPlantFragmentActivity::class.java)
            intent.putExtra(INTENT_EXTRA_KEY_ARENA, data as Arena)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = arenaList.count()
}
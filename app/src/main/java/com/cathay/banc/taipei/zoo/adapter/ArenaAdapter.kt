package com.cathay.banc.taipei.zoo.adapter

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.cathay.banc.taipei.zoo.activity.ArenaPlantFragmentActivity
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.entity.CommonItem
import com.cathay.banc.taipei.zoo.util.Constants

class ArenaAdapter(
    private val arenaList: List<Arena>,
) : CommonItemAdapter(arenaList) {

    override fun setOnItemClickLnr(view: View, commonItem: CommonItem) {
        view.setOnClickListener {
            val intent = Intent(it.context, ArenaPlantFragmentActivity::class.java)
            intent.putExtra(Constants.INTENT_EXTRA_KEY_ARENA, commonItem as Arena)
            it.context.startActivity(intent)
        }
    }
}

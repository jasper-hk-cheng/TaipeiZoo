package com.cathay.banc.taipei.zoo.adapter

import android.content.Intent
import android.view.View
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.activity.PlantActivity
import com.cathay.banc.taipei.zoo.entity.CommonItem
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_PLANT

class PlantAdapter(
    private val plantList: List<Plant>,
) : CommonItemAdapter(plantList) {

    override fun setOnItemClickLnr(view: View, CommonItem: CommonItem) {
        view.setOnClickListener {
            val intent = Intent(it.context, PlantActivity::class.java)
            intent.putExtra(INTENT_EXTRA_KEY_PLANT, CommonItem as Plant)
            it.context.startActivity(intent)
        }
    }
}

package com.cathay.banc.taipei.zoo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.databinding.ActivityPlantBinding
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_PLANT

class PlantActivity : AppCompatActivity() {

    private lateinit var activityPlantBinding: ActivityPlantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPlantBinding = DataBindingUtil.setContentView(this, R.layout.activity_plant)

        initViews()
        loadData()
    }

    private fun initViews() {
        //
        activityPlantBinding.toolbar.logo = getDrawable(R.drawable.baseline_arrow_back_18)
        activityPlantBinding.toolbar.titleMarginStart = resources.getDimension(R.dimen.toolbar_margin_start).toInt()
        activityPlantBinding.toolbar.getChildAt(0).setOnClickListener { finish() }
        setSupportActionBar(activityPlantBinding.toolbar)
    }

    private fun loadData() {
        val plant: Plant = intent.getParcelableExtra(INTENT_EXTRA_KEY_PLANT)
        //
        activityPlantBinding.toolbar.title = plant.fNameCh
        //
        activityPlantBinding.plant = plant
        activityPlantBinding.templatePlantDetail.plant = plant
    }
}
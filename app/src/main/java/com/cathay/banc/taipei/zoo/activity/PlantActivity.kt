package com.cathay.banc.taipei.zoo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.util.Constants
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_PLANT
import com.squareup.picasso.Picasso

class PlantActivity : AppCompatActivity() {

    /*
        views
     */
    private lateinit var toolbar: Toolbar
    private lateinit var ivAvatar: ImageView
    private lateinit var tvNameCh: TextView
    private lateinit var tvNameLatin: TextView
    private lateinit var tvAlias: TextView
    private lateinit var tvBrief: TextView
    private lateinit var tvFeature: TextView
    private lateinit var tvFunctionApplication: TextView
    private lateinit var tvUpdateDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant)

        initViews()
        loadData()
    }

    private fun initViews() {
        //
        toolbar = findViewById(R.id.toolbar)
        toolbar.logo = getDrawable(R.drawable.baseline_arrow_back_18)
        toolbar.titleMarginStart = resources.getDimension(R.dimen.toolbar_margin_start).toInt()
        toolbar.getChildAt(0).setOnClickListener { finish() }
        //
        ivAvatar = findViewById(R.id.ivAvatar)
        tvNameCh = findViewById(R.id.tvNameCh)
        tvNameLatin = findViewById(R.id.tvNameLatin)
        tvAlias = findViewById(R.id.tvAlias)
        tvBrief = findViewById(R.id.tvBrief)
        tvFeature = findViewById(R.id.tvFeature)
        tvFunctionApplication = findViewById(R.id.tvFunctionApplication)
        tvUpdateDate = findViewById(R.id.tvUpdateDate)
    }

    private fun loadData() {
        val plant: Plant = intent.getParcelableExtra(INTENT_EXTRA_KEY_PLANT)

        toolbar.title = plant.nameCh
        Picasso.with(this).load(plant.avatarUrl).into(ivAvatar)
        tvNameCh.text = plant.nameCh
        tvNameLatin.text = plant.nameLatin
        tvAlias.text = plant.alias
        tvBrief.text = plant.brief
        tvFeature.text = plant.feature
        tvFunctionApplication.text = plant.functionAndApplication
        tvUpdateDate.text = plant.updateDate
    }
}
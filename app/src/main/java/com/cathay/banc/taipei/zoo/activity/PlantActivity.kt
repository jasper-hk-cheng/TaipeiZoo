package com.cathay.banc.taipei.zoo.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_PLANT
import com.squareup.picasso.Picasso

class PlantActivity : AppCompatActivity() {

    private lateinit var unbinder: Unbinder

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.ivAvatar)
    lateinit var ivAvatar: ImageView

    @BindView(R.id.tvNameCh)
    lateinit var tvNameCh: TextView

    @BindView(R.id.tvNameLatin)
    lateinit var tvNameLatin: TextView

    @BindView(R.id.tvAlias)
    lateinit var tvAlias: TextView

    @BindView(R.id.tvBrief)
    lateinit var tvBrief: TextView

    @BindView(R.id.tvFeature)
    lateinit var tvFeature: TextView

    @BindView(R.id.tvFunctionApplication)
    lateinit var tvFunctionApplication: TextView

    @BindView(R.id.tvUpdateDate)
    lateinit var tvUpdateDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plant)

        initViews()
        loadData()
    }

    private fun initViews() {
        unbinder = ButterKnife.bind(this)
        //
        toolbar.logo = getDrawable(R.drawable.baseline_arrow_back_18)
        toolbar.titleMarginStart = resources.getDimension(R.dimen.toolbar_margin_start).toInt()
        toolbar.getChildAt(0).setOnClickListener { finish() }
        setSupportActionBar(toolbar)
    }

    private fun loadData() {
        val plant: Plant = intent.getParcelableExtra(INTENT_EXTRA_KEY_PLANT)
        //
        toolbar.title = plant._fNameCh
        //
        Picasso.with(this).load(plant._fPic01Url).into(ivAvatar)
        tvNameCh.text = plant._fNameCh
        tvNameLatin.text = plant._fNameLatin
        tvAlias.text = plant._fAlsoKnown
        tvBrief.text = plant._fBrief
        tvFeature.text = plant._fFeature
        tvFunctionApplication.text = plant._fFunctionAndApplication
        tvUpdateDate.text = plant._fUpdate
    }
}
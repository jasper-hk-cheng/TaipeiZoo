package com.cathay.banc.taipei.zoo.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.util.Constants
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_ARENA

class ArenaPlantFragmentActivity : AppCompatActivity() {

    /*
        views
     */
    private lateinit var unbinder: Unbinder

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arena_plant_fragment)

        initViews()
        loadData()
    }

    private fun initViews() {
        unbinder = ButterKnife.bind(this)
        val arena: Arena = intent.getParcelableExtra(INTENT_EXTRA_KEY_ARENA)
        //
        toolbar.logo = getDrawable(R.drawable.baseline_arrow_back_18)
        toolbar.title = arena.eName
        toolbar.titleMarginStart = resources.getDimension(R.dimen.toolbar_margin_start).toInt()
        toolbar.getChildAt(0).setOnClickListener { finish() }
        setSupportActionBar(toolbar)
    }

    private fun loadData() {

    }
}

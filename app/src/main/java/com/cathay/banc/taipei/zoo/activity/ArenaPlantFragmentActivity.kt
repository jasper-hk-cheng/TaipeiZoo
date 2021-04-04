package com.cathay.banc.taipei.zoo.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.util.Constants
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_ARENA

class ArenaPlantFragmentActivity : AppCompatActivity() {

    /*
        views
     */
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arena_plant_fragment)

        initViews()
        loadData()
    }

    private fun initViews() {
        val arena: Arena = intent.getParcelableExtra(INTENT_EXTRA_KEY_ARENA)
        //
        toolbar = findViewById(R.id.toolbar)
        toolbar.logo = getDrawable(R.drawable.baseline_arrow_back_18)
        toolbar.title = arena.title
        toolbar.titleMarginStart = resources.getDimension(R.dimen.toolbar_margin_start).toInt()
        toolbar.getChildAt(0).setOnClickListener { finish() }
        setSupportActionBar(toolbar)
    }

    private fun loadData() {

    }
}

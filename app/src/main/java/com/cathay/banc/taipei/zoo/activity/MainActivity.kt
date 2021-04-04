package com.cathay.banc.taipei.zoo.activity

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.adapter.ArenaAdapter
import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.presenter.ArenaPresenter
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_ARENA

class MainActivity : AppCompatActivity(), ZooContract.IArenaView {

    /*
        views
     */
    private lateinit var lvArenaList: ListView
    private lateinit var toolbar: Toolbar

    /*
        presenter
     */
    private val arenaPresenter = ArenaPresenter(this, this)

    /*
        adapters
     */
    private lateinit var arenaAdapter: ArenaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        loadData()
    }

    private fun initViews() {
        //
        toolbar = findViewById(R.id.toolbar)
        toolbar.logo = getDrawable(R.drawable.baseline_menu_36)
        toolbar.title = getString(R.string.app_name)
        toolbar.titleMarginStart = resources.getDimension(R.dimen.toolbar_margin_start).toInt()
        toolbar.subtitle = getString(R.string.toolbar_subtitle)
        setSupportActionBar(toolbar)
        //
        lvArenaList = findViewById(R.id.lvArena)
        lvArenaList.onItemClickListener = onClickArenaLnr
    }

    private fun loadData() {
        arenaPresenter.getArenaList()
    }

    override fun onArenaListResult(arenaList: List<Arena>) {
        //
        arenaAdapter = ArenaAdapter(arenaList)
        lvArenaList.adapter = arenaAdapter
    }

    private val onClickArenaLnr = AdapterView.OnItemClickListener { _, _, position, _ ->
        val arena: Arena = arenaAdapter.getItem(position)
        /*
            intent
         */
        val intent = Intent(this@MainActivity, ArenaPlantFragmentActivity::class.java)
        intent.putExtra(INTENT_EXTRA_KEY_ARENA, arena)
        startActivity(intent)
    }
}

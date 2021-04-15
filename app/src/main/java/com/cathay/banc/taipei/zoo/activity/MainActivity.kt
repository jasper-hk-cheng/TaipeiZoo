package com.cathay.banc.taipei.zoo.activity

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.adapter.CommonItemAdapter
import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.presenter.ArenaPresenter
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_ARENA
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), ZooContract.IArenaView {

    /*
        views
     */
    private lateinit var unbinder: Unbinder

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.lvArena)
    lateinit var lvArena: ListView

    /*
        presenter
     */
    private val arenaPresenter: ArenaPresenter by inject {
        parametersOf(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        loadData()
    }

    private fun initViews() {
        unbinder = ButterKnife.bind(this)
        //
        toolbar.logo = getDrawable(R.drawable.baseline_menu_36)
        toolbar.title = getString(R.string.app_name)
        toolbar.titleMarginStart = resources.getDimension(R.dimen.toolbar_margin_start).toInt()
        toolbar.subtitle = getString(R.string.toolbar_subtitle)
        setSupportActionBar(toolbar)
    }

    private fun loadData() {
        arenaPresenter.getArenaList()
    }

    override fun onArenaListResult(arenaList: List<Arena>) {
        lvArena.adapter = CommonItemAdapter(arenaList)
        lvArena.onItemClickListener = onArenaItemClickLnr
    }

    private val onArenaItemClickLnr = AdapterView.OnItemClickListener { _, _, position, _ ->
        val intent = Intent(this, ArenaPlantFragmentActivity::class.java)
        intent.putExtra(INTENT_EXTRA_KEY_ARENA, lvArena.adapter.getItem(position) as Arena)
        startActivity(intent)
    }
}

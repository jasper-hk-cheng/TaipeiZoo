package com.cathay.banc.taipei.zoo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.adapter.ArenaAdapter
import com.cathay.banc.taipei.zoo.adapter.CommonItemAdapter
import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.presenter.ArenaPresenter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), ZooContract.IArenaView {

    /*
        views
     */
    private lateinit var unbinder: Unbinder

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.rvArena)
    lateinit var rvArena: RecyclerView

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
        //
        rvArena.layoutManager = LinearLayoutManager(this)
    }

    private fun loadData() {
        arenaPresenter.getArenaList()
    }

    override fun onArenaListResult(arenaList: List<Arena>) {
        rvArena.adapter = ArenaAdapter(arenaList)
    }
}

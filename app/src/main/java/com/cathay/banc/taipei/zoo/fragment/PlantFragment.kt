package com.cathay.banc.taipei.zoo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.adapter.PlantAdapter
import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.presenter.PlantPresenter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class PlantFragment : Fragment(), ZooContract.IPlantView {

    /*
        views
     */
    private lateinit var unbinder: Unbinder

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.rvPlant)
    lateinit var rvPlant: RecyclerView

    /*
        presenter
     */
    private val plantPresenter: PlantPresenter by inject {
        parametersOf(this)
    }

    override fun onCreateView(layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = layoutInflater.inflate(R.layout.fragment_plant_list, container)
        unbinder = ButterKnife.bind(this, view)
        //
        toolbar.title = getString(R.string.plant_list_title)
        //
        rvPlant.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        plantPresenter.getPlantList()
    }

    override fun onPlantListResult(plantList: List<Plant>) {
        rvPlant.adapter = PlantAdapter(plantList)
    }
}
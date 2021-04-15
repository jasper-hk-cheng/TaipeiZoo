package com.cathay.banc.taipei.zoo.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.activity.PlantActivity
import com.cathay.banc.taipei.zoo.adapter.CommonItemAdapter
import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.presenter.PlantPresenter
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_PLANT
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class PlantFragment : Fragment(), ZooContract.IPlantView {

    /*
        views
     */
    private lateinit var unbinder: Unbinder

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.lvPlant)
    lateinit var lvPlant: ListView

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

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        plantPresenter.getPlantList()
    }

    override fun onPlantListResult(plantList: List<Plant>) {
        lvPlant.adapter = CommonItemAdapter(plantList)
        lvPlant.onItemClickListener = onPlantItemClickLnr
    }

    private val onPlantItemClickLnr = AdapterView.OnItemClickListener { _, _, position, _ ->
        val intent = Intent(requireContext(), PlantActivity::class.java)
        intent.putExtra(INTENT_EXTRA_KEY_PLANT, lvPlant.adapter.getItem(position) as Plant)
        requireContext().startActivity(intent)
    }
}
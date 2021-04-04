package com.cathay.banc.taipei.zoo.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.cathay.banc.taipei.zoo.R
import com.cathay.banc.taipei.zoo.activity.PlantActivity
import com.cathay.banc.taipei.zoo.adapter.PlantAdapter
import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.presenter.PlantPresenter
import com.cathay.banc.taipei.zoo.util.Constants.INTENT_EXTRA_KEY_PLANT

class PlantFragment : Fragment(), ZooContract.IPlantView {

    /*
        views
     */
    private lateinit var toolbar: Toolbar
    private lateinit var lvPlant: ListView

    /*
        adapter
     */
    private lateinit var plantAdapter: PlantAdapter

    /*
        presenter
     */
    private lateinit var plantPresenter: PlantPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)

        plantPresenter = PlantPresenter(context, this)
    }

    override fun onCreateView(layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = layoutInflater.inflate(R.layout.fragment_plant_list, container)

        toolbar = view.findViewById<Toolbar>(R.id.toolbar).apply { title = getString(R.string.plant_list_title) }
        lvPlant = view.findViewById<ListView>(R.id.lvPlant).apply { onItemClickListener = onPlantItemClick }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        plantPresenter.getPlantList()
    }

    override fun onPlantListResult(plantList: List<Plant>) {
        plantAdapter = PlantAdapter(plantList)
        lvPlant.adapter = plantAdapter
    }

    private val onPlantItemClick = AdapterView.OnItemClickListener { _, _, position, _ ->
        val plant: Plant = plantAdapter.getItem(position)
        /*
            intent
         */
        val intent = Intent(requireContext(), PlantActivity::class.java)
        intent.putExtra(INTENT_EXTRA_KEY_PLANT, plant)
        startActivity(intent)
    }
}
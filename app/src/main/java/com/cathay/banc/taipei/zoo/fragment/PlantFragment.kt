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
import com.cathay.banc.taipei.zoo.databinding.FragmentPlantListBinding
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.presenter.PlantPresenter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class PlantFragment : Fragment(), ZooContract.IPlantView {

    /*
        views
     */
    private lateinit var fragmentPlantListBinding: FragmentPlantListBinding

    /*
        presenter
     */
    private val plantPresenter: PlantPresenter by inject {
        parametersOf(this)
    }

    override fun onCreateView(layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentPlantListBinding = FragmentPlantListBinding.inflate(layoutInflater, container, false)
        //
        fragmentPlantListBinding.plantPresenter = plantPresenter
        fragmentPlantListBinding.plantSearchCondition = plantPresenter.plantSearchCondition
        //
        return fragmentPlantListBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //
        fragmentPlantListBinding.toolbar.title = getString(R.string.plant_list_title)
        //
        fragmentPlantListBinding.rvPlant.layoutManager = LinearLayoutManager(requireContext())
        fragmentPlantListBinding.rvPlant.adapter = PlantAdapter(mutableListOf())
        //
        plantPresenter.getListWithCondition()
    }

    override fun onPlantListResult(plantList: List<Plant>) {
        val plantAdapter = fragmentPlantListBinding.rvPlant.adapter as PlantAdapter
        plantAdapter.plantList.apply { clear() }.addAll(plantList)
        plantAdapter.notifyDataSetChanged()
    }
}

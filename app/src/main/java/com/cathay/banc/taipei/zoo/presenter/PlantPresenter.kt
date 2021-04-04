package com.cathay.banc.taipei.zoo.presenter

import android.content.Context
import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.repository.IZooRepository
import com.cathay.banc.taipei.zoo.repository.ZooRepository

class PlantPresenter(
    context: Context,
    private val plantView: ZooContract.IPlantView,
) : ZooContract.IPlantPresenter {

    private val zooRepository: IZooRepository = ZooRepository(context)

    override fun getPlantList() {
        zooRepository.getPlantList(object : IZooRepository.PlantListCallback {
            override fun onPlantListResult(plantList: List<Plant>) {
                plantView.onPlantListResult(plantList)
            }
        })
    }
}

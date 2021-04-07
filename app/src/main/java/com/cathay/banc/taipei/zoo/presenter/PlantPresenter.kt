package com.cathay.banc.taipei.zoo.presenter

import android.content.Context
import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.repository.IZooRepository
import com.cathay.banc.taipei.zoo.repository.ZooRepository

class PlantPresenter(
    private val plantView: ZooContract.IPlantView,
    private val zooRepository: IZooRepository,
) : ZooContract.IPlantPresenter {

    override fun getPlantList() {
        zooRepository.getPlantList(object : IZooRepository.PlantListCallback {
            override fun onPlantListResult(plantList: List<Plant>) {
                plantView.onPlantListResult(plantList)
            }
        })
    }
}

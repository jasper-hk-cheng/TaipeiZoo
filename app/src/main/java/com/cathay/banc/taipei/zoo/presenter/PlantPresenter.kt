package com.cathay.banc.taipei.zoo.presenter

import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.entity.PlantSearchCondition
import com.cathay.banc.taipei.zoo.repository.IZooRepository

class PlantPresenter(
    private val plantView: ZooContract.IPlantView,
    private val zooRepository: IZooRepository,
    val plantSearchCondition: PlantSearchCondition,
) : ZooContract.IPlantPresenter {

    override fun getListWithCondition() {
        zooRepository.getPlantList(plantSearchCondition, object : IZooRepository.PlantListCallback {
            override fun onPlantListResult(plantList: List<Plant>) {
                plantView.onPlantListResult(plantList)
            }
        })
    }

    override fun getHome() {
        plantSearchCondition.goHome()
        getListWithCondition()
    }

    override fun getNextPage() {
        plantSearchCondition.goNextPage()
        getListWithCondition()
    }

    override fun getPreviousPage() {
        plantSearchCondition.goPreviousPage()
        getListWithCondition()
    }
}

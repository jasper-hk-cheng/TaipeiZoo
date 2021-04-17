package com.cathay.banc.taipei.zoo.contract

import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.entity.PlantSearchCondition

class ZooContract {

    interface IArenaPresenter {
        fun getArenaList()
    }

    interface IArenaView {
        fun onArenaListResult(arenaList: List<Arena>)
    }

    interface IPlantPresenter {
        fun getListWithCondition()
        fun getHome()
        fun getNextPage()
        fun getPreviousPage()
    }

    interface IPlantView {
        fun onPlantListResult(plantList: List<Plant>)
    }
}

package com.cathay.banc.taipei.zoo.contract

import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.entity.Plant

class ZooContract {

    interface IArenaPresenter {
        fun getArenaList()
    }

    interface IArenaView {
        fun onArenaListResult(arenaList: List<Arena>)
    }

    interface IPlantPresenter {
        fun getPlantList()
    }

    interface IPlantView {
        fun onPlantListResult(plantList: List<Plant>)
    }
}

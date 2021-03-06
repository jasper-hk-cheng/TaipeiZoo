package com.cathay.banc.taipei.zoo.repository

import com.cathay.banc.taipei.zoo.api.ZooAPI
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.entity.Plant
import com.cathay.banc.taipei.zoo.entity.PlantSearchCondition

interface IZooRepository {

    fun getArenaList(arenaListCallback: ArenaListCallback)

    interface ArenaListCallback {
        fun onArenaListResult(arenaList: List<Arena>)
    }

    fun getPlantList(plantSearchCondition: PlantSearchCondition, plantListCallback: PlantListCallback)

    interface PlantListCallback {
        fun onPlantListResult(plantList: List<Plant>)
    }
}

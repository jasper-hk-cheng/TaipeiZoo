package com.cathay.banc.taipei.zoo.presenter

import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.repository.IZooRepository
import com.cathay.banc.taipei.zoo.repository.ZooRepository

class ArenaPresenter(
    private val arenaView: ZooContract.IArenaView,
    private val zooRepository: ZooRepository,
) : ZooContract.IArenaPresenter {

    override fun getArenaList() {
        zooRepository.getArenaList(object : IZooRepository.ArenaListCallback {
            override fun onArenaListResult(arenaList: List<Arena>) {
                arenaView.onArenaListResult(arenaList)
            }
        })
    }
}

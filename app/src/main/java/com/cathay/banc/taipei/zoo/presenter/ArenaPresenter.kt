package com.cathay.banc.taipei.zoo.presenter

import android.content.Context
import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.entity.Arena
import com.cathay.banc.taipei.zoo.repository.IZooRepository
import com.cathay.banc.taipei.zoo.repository.ZooRepository

class ArenaPresenter(
    context: Context,
    private val arenaView: ZooContract.IArenaView,
) : ZooContract.IArenaPresenter {

    private val zooRepository: IZooRepository = ZooRepository(context)

    override fun getArenaList() {
        zooRepository.getArenaList(object : IZooRepository.ArenaListCallback {
            override fun onArenaListResult(arenaList: List<Arena>) {
                arenaView.onArenaListResult(arenaList)
            }
        })
    }
}

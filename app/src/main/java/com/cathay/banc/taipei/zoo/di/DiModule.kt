package com.cathay.banc.taipei.zoo.di

import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.presenter.ArenaPresenter
import com.cathay.banc.taipei.zoo.presenter.PlantPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val arenaPresenterModule = module {
    single<ArenaPresenter> { (view: ZooContract.IArenaView) ->
        ArenaPresenter(androidContext() ,view)
    }
}

val plantPresenterModule = module {
    single<PlantPresenter> { (view: ZooContract.IPlantView) ->
        PlantPresenter(androidContext(), view)
    }
}

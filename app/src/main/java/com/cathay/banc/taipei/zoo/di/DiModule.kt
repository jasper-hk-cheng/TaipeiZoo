package com.cathay.banc.taipei.zoo.di

import com.cathay.banc.taipei.zoo.api.ZooAPI
import com.cathay.banc.taipei.zoo.contract.ZooContract
import com.cathay.banc.taipei.zoo.presenter.ArenaPresenter
import com.cathay.banc.taipei.zoo.presenter.PlantPresenter
import com.cathay.banc.taipei.zoo.repository.ZooRepository
import com.cathay.banc.taipei.zoo.util.Constants.BASE_URL
import com.squareup.okhttp.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
    presenter
 */
val arenaPresenterModule = module {
    factory<ArenaPresenter> { (view: ZooContract.IArenaView) ->
        ArenaPresenter(view, get<ZooRepository>())
    }
}

val plantPresenterModule = module {
    factory<PlantPresenter> { (view: ZooContract.IPlantView) ->
        PlantPresenter(view, get<ZooRepository>())
    }
}

/*
    repository
 */
val repositoryModule = module {
    factory<ZooRepository> {
        ZooRepository(androidContext(), get<ZooAPI>())
    }
}

/*
    API
 */
// TODO: 2021/4/7 add OkHttpClient's Interceptor
val retrofitModule = module {
    factory<Retrofit> {
        val okHttpClient = OkHttpClient()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}

val zooApiModule = module {
    factory<ZooAPI> {
        get<Retrofit>().create(ZooAPI::class.java)
    }
}


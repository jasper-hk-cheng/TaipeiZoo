package com.cathay.banc.taipei.zoo.api

import com.cathay.banc.taipei.zoo.entity.ArenaResult
import com.cathay.banc.taipei.zoo.entity.PlantResult
import com.cathay.banc.taipei.zoo.util.Constants.API_QUERY_PARAM_SCOPE
import retrofit2.Call
import retrofit2.http.GET

interface ZooAPI {

    @GET("5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=$API_QUERY_PARAM_SCOPE")
    fun getArenaList(): Call<ArenaResult>

    @GET("f18de02f-b6c9-47c0-8cda-50efad621c14?scope=$API_QUERY_PARAM_SCOPE")
    fun getPlantList(): Call<PlantResult>
}

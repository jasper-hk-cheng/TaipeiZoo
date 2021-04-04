package com.cathay.banc.taipei.zoo.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.cathay.banc.taipei.zoo.api.ZooApiFactory
import com.cathay.banc.taipei.zoo.entity.*
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ZooRepository(
    private val context: Context,
) : IZooRepository {

    override fun getArenaList(arenaListCallback: IZooRepository.ArenaListCallback) {
        ZooApiFactory.instance.getArenaList().enqueue(object : Callback<ArenaResult> {

            override fun onResponse(call: Call<ArenaResult>, response: Response<ArenaResult>) {
                val arenaList: List<Arena> = if (response.body() != null) response.body()!!.result.results else listOf()
                arenaListCallback.onArenaListResult(arenaList)
            }

            override fun onFailure(call: Call<ArenaResult>, throwable: Throwable) {
                Log.e("get_arena_list", throwable.message)
                Toast.makeText(context, throwable.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun getPlantList(plantListCallback: IZooRepository.PlantListCallback) {
        ZooApiFactory.instance.getPlantList().enqueue(object : Callback<PlantResult> {

            override fun onResponse(call: Call<PlantResult>, response: Response<PlantResult>) {
                val plantList: List<Plant> = if (response.body() != null) response.body()!!.result.results else listOf()
                plantListCallback.onPlantListResult(plantList)
            }

            override fun onFailure(call: Call<PlantResult>, throwable: Throwable) {
                Log.e("get_plant_list", throwable.message)
                Toast.makeText(context, throwable.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}

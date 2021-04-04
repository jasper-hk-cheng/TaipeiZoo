package com.cathay.banc.taipei.zoo.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ZooApiFactory {

    // TODO: 2021/4/3 attach log interceptor
    private val okHttpClient = OkHttpClient()
    private val retrofit: Retrofit
    private val zooAPI: ZooAPI

    /*
        constants
     */
    // XXX what's the kotlin "protected" accessing decoration's scope ??
    private const val BASE_URL = "https://data.taipei/api/v1/dataset/"
    internal const val API_QUERY_PARAM_SCOPE = "resourceAquire"

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        zooAPI = retrofit.create(ZooAPI::class.java)
    }

    val instance: ZooAPI
        get() = zooAPI
}

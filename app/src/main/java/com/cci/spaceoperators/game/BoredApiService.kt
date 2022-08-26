package com.cci.spaceoperators.game

import com.cci.spaceoperators.network.PayloadGameStart
import com.cci.spaceoperators.utils.SpaceOperatorsMoshi.moshi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_PATH = "http://www.boredapi.com/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_PATH)
    .build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface BoredApiService {
    @GET("activity")
    suspend fun getActivityGameStart(): PayloadGameStart
}

object BoredApi {
    val retrofitService: BoredApiService by lazy {
        retrofit.create(BoredApiService::class.java)
    }
}
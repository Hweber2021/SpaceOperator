package com.cci.spaceoperators.game

import com.cci.spaceoperators.network.*
import com.cci.spaceoperators.users.User
import com.cci.spaceoperators.utils.SpaceOperatorsMoshi.moshi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

private const val BASE_PATH = "http://www.boredapi.com/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_PATH)
    .build()


interface BoredApiService {

    @GET("UserConnectPayload")
    suspend fun getPlayerConnect(): UserConnectPayload

    @POST("UserListUpdatePayload")
    suspend fun postUpdatePlayerList(): UserListUpdatePayload

    @GET("UserUpdateStatusPayload")
    suspend fun getPlayerStatusUpdate(): UserUpdateStatusPayload

    @POST("PayloadGameStart/PayloadGameStart")
    suspend fun postActivityGameStart(): PayloadGameStart

    @GET("PayloadGameStart/PayloadGameFinish")
    suspend fun getGameFinish(): PayloadGameFinish

    @POST("PayloadGameStart/PayloadGameShipDestroyed")
    suspend fun postGameShipDestroyed(): PayloadGameShipDestroyed



}

object BoredApi {
    val retrofitService: BoredApiService by lazy {
        retrofit.create(BoredApiService::class.java)
    }
}
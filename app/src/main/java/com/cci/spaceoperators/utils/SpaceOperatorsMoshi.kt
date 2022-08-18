package com.cci.spaceoperators.utils

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object SpaceOperatorsMoshi {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .add(RoomDateConverter())
        .build()
}
package com.cci.spaceoperators.game

import com.squareup.moshi.Json

data class BoredActivity(
    @Json(name = "activity")
    val task: String,

    @Json(name = "user_name")
    val name: String
)
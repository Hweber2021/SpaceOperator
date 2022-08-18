package com.cci.spaceoperators.game

import com.cci.spaceoperators.users.User
import com.squareup.moshi.Json
import com.squareup.moshi.Types

data class SpaceOperatorsActivitySendUser(
    @Json(name = "type")
    val type: String,

    @Json(name = "data")
    val data: User
)

data class SpaceOperatorsActivityRecoverUser(
    @Json(name = "type")
    val types: String,
)
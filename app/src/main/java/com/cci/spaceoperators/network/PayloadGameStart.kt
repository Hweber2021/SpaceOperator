package com.cci.spaceoperators.network

import com.cci.spaceoperators.game.Game
import com.cci.spaceoperators.users.User
import com.squareup.moshi.Json

data class PayloadGameStart(
    val type: String = PayloadType.start.toString()
) : Payload() {
    fun jsonEncodeToString(): String {
        return super.jsonEncodeToString(this)
    }
}

data class PayloadUpdateIntegrity(
    val type: String = PayloadType.integrity.toString(),
    val data: Float
) : Payload() {
    fun jsonEncodeToString(): String {
        return super.jsonEncodeToString(this)
    }
}

data class PayloadGameFinish(
    val type: String = PayloadType.finish.toString(),
    val data: User
) : Payload() {
    fun jsonEncodeToString(): String {
        return super.jsonEncodeToString(this)
    }
}

data class PayloadGameShipDestroyed(
    val type: String = PayloadType.destroyed.toString(),
    val data: Int
) : Payload() {
    fun jsonEncodeToString(): String {
        return super.jsonEncodeToString(this)
    }
}
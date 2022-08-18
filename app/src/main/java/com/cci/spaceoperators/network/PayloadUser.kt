package com.cci.spaceoperators.network

import androidx.lifecycle.LiveData
import com.squareup.moshi.Json
import com.cci.spaceoperators.users.User

data class UserConnectPayload(
    val type: String = PayloadType.connect.toString(),
    val data: User
) : Payload() {

    fun jsonEncodeToString(): String {
        return super.jsonEncodeToString(this)
    }
}

data class UserListUpdatePayload(
    val type: String = PayloadType.players.toString(),
    val data: List<User>
) : Payload() {

    fun jsonEncodeToString(): String {
        return super.jsonEncodeToString(this)
    }
}

data class UserUpdateStatusPayload(
    val type: String = PayloadType.status.toString(),
    val data: User
) : Payload() {

    fun jsonEncodeToString(): String {
        return super.jsonEncodeToString(this)
    }

}
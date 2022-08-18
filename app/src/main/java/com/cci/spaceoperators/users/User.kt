package com.cci.spaceoperators.users

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.Inet4Address

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val id: Long,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "inetAddress")
    val inetAddress: String,

    @ColumnInfo(name = "portNumber")
    val port: Int = 8888,

    @ColumnInfo(name = "status")
    val status: Boolean = false,

    @ColumnInfo(name = "nbTour")
    val nbTour: Int = 0
)

@Entity(tableName = "operators")
data class operator(
    @Embedded
    val user: User,

    @ColumnInfo(name = "code")
    val code: String = ""
)


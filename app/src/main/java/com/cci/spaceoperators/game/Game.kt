package com.cci.spaceoperators.game

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cci.spaceoperators.users.User
import com.squareup.moshi.Json

@Entity(tableName = "game")
data class Game(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "game_id")
    val id: Long,

    @ColumnInfo(name = "game_player")
    val player: List<User>,

    @ColumnInfo(name = "operation")
    val operation: List<String>,

    @ColumnInfo(name = "turn")
    val turn: Int = 0,

    @ColumnInfo(name = "integrity")
    @Json
    val integrity: Float
)

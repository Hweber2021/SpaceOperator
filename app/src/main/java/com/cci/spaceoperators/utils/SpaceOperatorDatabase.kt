package com.cci.spaceoperators.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cci.spaceoperators.game.Game
import com.cci.spaceoperators.users.User
import com.cci.spaceoperators.users.UserDao
import com.cci.spaceoperators.users.operator

@Database(
    entities = [User::class, Game::class, operator::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(RoomDateConverter::class)
abstract class SpaceOperatorDatabase: RoomDatabase(){
    abstract fun usersDao(): UserDao

}
package com.cci.spaceoperators.users

import android.net.InetAddresses
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insertOne(user: User): Long

    @Query("SELECT COUNT(*) FROM users WHERE username = :username")
    fun doesUserExist(username: String): Int

    @Query("SELECT COUNT(NbTour) FROM users WHERE username =:username")
    fun getNbTourUser(username: String): LiveData<Int>

    @Query("SELECT username FROM users where user_id =:userId")
    fun getUsername(userId: String): String

    @Query("SELECT status FROM users where username =:username")
    fun getStatusByUsername(username: String): Boolean

    @Query("""
    SELECT * 
    FROM 
        users u
    WHERE
        u.username = :username
    LIMIT 1
  """)
    fun getByUsername(username: String): User?

    @Query("""
    SELECT * 
    FROM
        users u
    WHERE
        u.status = :status
    """)
    fun getByStatus(status: Boolean): User?

    @Query("""
        SELECT *
        FROM
            users u
        WHERE
            u.inetAddress = :inetAddress
        LIMIT 8
    """)
    fun getByInetAddress(inetAddress: String): User?

}
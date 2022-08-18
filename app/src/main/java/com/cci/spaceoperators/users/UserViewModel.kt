package com.cci.spaceoperators.users

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.cci.spaceoperators.utils.SpaceOperatorDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    val db = Room.databaseBuilder(
        application.applicationContext,
        SpaceOperatorDatabase::class.java,
        "spaceoperators-database"
    ).build()

    val usersDao = db.usersDao()

    val currentUser = MutableLiveData<User>(null)

    fun changeUsername(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = usersDao.getByUsername(username)

            if (user == null) {
                val id = usersDao.insertOne(User(0, username, "127.0.0.1", 8888, false, 0))

                currentUser.postValue(
                    User(id, username, "127.0.0.1", 8888, false, 0)
                )
            }
            else {
                currentUser.postValue(user!!)
            }
        }
    }

    fun getnbTourUser(username: String): LiveData<Int> {
            return usersDao.getNbTourUser(username)
    }

    fun getUsername(userId: String): String{
        return usersDao.getUsername(userId)
    }


}
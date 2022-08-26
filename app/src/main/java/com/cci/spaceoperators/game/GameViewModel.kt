package com.cci.spaceoperators.game

import android.app.Application
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.cci.spaceoperators.users.User
import com.cci.spaceoperators.utils.SocketViewModel
import com.cci.spaceoperators.utils.SpaceOperatorDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.Inet4Address
import java.net.NetworkInterface

class GameViewModel(application: Application): AndroidViewModel(application) {

    val boredApiService = BoredApi.retrofitService

    val db = Room.databaseBuilder(
        application.applicationContext,
        SpaceOperatorDatabase::class.java,
        "spaceoperators-database"
    ).build()

    val usersDao = db.usersDao()

    val currentUser = MutableLiveData<User>(null)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val networkInterfaces = NetworkInterface.getNetworkInterfaces()

            val ip =
                networkInterfaces.toList()
                    .find { it.displayName == "wlan0"}
                    ?.inetAddresses?.toList()
                    ?.find { it is Inet4Address }
                    ?.hostAddress ?: "127.0.0.1"

            viewModelScope.launch(Dispatchers.Main) {
                Toast.makeText(application, ip, Toast.LENGTH_LONG).show()
            }
        }
    }

    fun observePlayerStatus(username: String)
    {
        usersDao.getStatusByUsername(username)
    }


}
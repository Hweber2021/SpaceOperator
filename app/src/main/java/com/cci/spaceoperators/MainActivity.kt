package com.cci.spaceoperators

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.cci.spaceoperators.databinding.ActivityMainBinding
import com.cci.spaceoperators.game.JoinGameDialogFragment
import com.cci.spaceoperators.users.UserViewModel
import com.cci.spaceoperators.users.UsernameDialogFragment
import com.cci.spaceoperators.utils.SocketViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        userViewModel.currentUser.observe(this) { user ->
            if (user != null) {
                binding.usernameTextView.text = user.username
            }
        }

        binding.modifyUsernameButton.setOnClickListener {
            openUsernameDialog()
        }

        val username =
            getPreferences(Context.MODE_PRIVATE)
                .getString("username", null)

        if (username == null) {
            openUsernameDialog()
        } else {
            userViewModel.changeUsername(username!!)
        }




    }

    fun openUsernameDialog() {
        UsernameDialogFragment()
            .show(
                supportFragmentManager,
                "username-dialog"
            )
    }


}
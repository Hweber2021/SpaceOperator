package com.cci.spaceoperators.users

import android.content.Context
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.cci.spaceoperators.databinding.ListPlayerBinding

class UserViewHolder(
    binding: ListPlayerBinding,
    onPlayerStatusSelected: Context
): RecyclerView.ViewHolder(binding.root) {

    val playerStatus = binding.playerStatus
    val playerName = binding.playerName

    var playerId: Int? = null

    init {

    }

}
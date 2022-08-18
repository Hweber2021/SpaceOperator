package com.cci.spaceoperators.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cci.spaceoperators.databinding.ListPlayerBinding

class UserAdapter(var users: List<User>
): RecyclerView.Adapter<UserViewHolder>() {

    fun updatePlayers(newPlayers: List<User>) {
        this.users = newPlayers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): UserViewHolder =
        UserViewHolder(
            ListPlayerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            parent.context
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]

        holder.playerName.text = user.username
        holder.playerStatus.text = user.status.toString()
        holder.playerId = user.id.toInt()
    }

    override fun getItemCount(): Int = users.size

}
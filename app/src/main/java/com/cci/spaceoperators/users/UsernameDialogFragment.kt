package com.cci.spaceoperators.users

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.cci.spaceoperators.databinding.UsernameDialogBinding

class UsernameDialogFragment: DialogFragment() {

    private var _binding: UsernameDialogBinding? = null
    private lateinit var binding: UsernameDialogBinding

    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = UsernameDialogBinding.inflate(
            layoutInflater,
            null,
            false
        )
        binding = _binding!!

        val builder = AlertDialog.Builder(requireActivity())
        val dialog =
            builder
                .setMessage("Donner votre nom nouvel associer :")
                .setView(binding.root)
                .setPositiveButton("Save") { dialog, id ->
                    val prefs = requireActivity().getPreferences(Context.MODE_PRIVATE)

                    prefs.edit()
                        .putString("username", binding.editPersonName.text.toString())
                        .apply()

                    userViewModel.changeUsername(
                        binding.editPersonName.text.toString()
                    )
                }
                .create()

        return dialog
    }
}
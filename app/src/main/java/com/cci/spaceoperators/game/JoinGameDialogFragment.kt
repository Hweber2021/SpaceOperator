package com.cci.spaceoperators.game

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.cci.spaceoperators.databinding.JoinGameDialogBinding

class JoinGameDialogFragment: DialogFragment() {

    private var _binding: JoinGameDialogBinding? = null
    private lateinit var binding: JoinGameDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        _binding = JoinGameDialogBinding.inflate(
            layoutInflater,
            null,
            false
        )
        binding = _binding!!

        val builder = AlertDialog.Builder(requireActivity())
        val dialog =
            builder
                .setTitle("Entrer les informations de connexion :")
                .setView(binding.root)
                .setPositiveButton("connexion") { dialog, id ->
                    val prefs = requireActivity().getPreferences(Context.MODE_PRIVATE)

                    prefs.edit()
                        .putString("hostIP", binding.editTextHostIP.text.toString())
                        .apply()

                    prefs.edit()
                        .putString("hostPortNumber", binding.editTextHostPortNumber.text.toString())
                        .apply()


                }.setNegativeButton("annuler", DialogInterface.OnClickListener { dialog, id ->
                    getDialog()?.cancel()
                })
                .create()

        return dialog
    }

}
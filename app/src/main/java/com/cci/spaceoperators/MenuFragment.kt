package com.cci.spaceoperators

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.cci.spaceoperators.databinding.FragmentMenuBinding
import com.cci.spaceoperators.game.JoinGameDialogFragment

class MenuFragment: Fragment() {

    private var binding: FragmentMenuBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.btnNewGame?.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToNewGameFragment()

            findNavController().navigate(action)

        }

        binding?.btnJoinGame?.setOnClickListener {
            openJoinNewGameDialog()
        }

        binding?.btnHistorique?.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToHistoryFragment()

            findNavController().navigate(action)
        }

        binding?.btnExit?.setOnClickListener {
            android.os.Process.killProcess(android.os.Process.myPid())
            System.exit(1)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun openJoinNewGameDialog()
    {
        JoinGameDialogFragment().show(
            childFragmentManager,
            "join-game-dialog"
        )
    }


}
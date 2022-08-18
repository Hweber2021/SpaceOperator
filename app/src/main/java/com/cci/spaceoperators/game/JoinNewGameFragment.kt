package com.cci.spaceoperators.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.cci.spaceoperators.databinding.FragmentNewGameBinding
import com.cci.spaceoperators.databinding.JoinNewgameFragmentBinding
import com.cci.spaceoperators.users.User
import com.cci.spaceoperators.utils.SocketViewModel

class JoinNewGameFragment: Fragment() {

    private var _binding: JoinNewgameFragmentBinding? = null
    private lateinit var binding: JoinNewgameFragmentBinding

    private val socketViewModel: SocketViewModel by viewModels()

    val players = MutableLiveData<List<User>>(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = JoinNewgameFragmentBinding.inflate(inflater, container, false)
        binding = _binding!!

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.startNewGameButton.setOnClickListener {
            val action = JoinNewGameFragmentDirections.actionJoinNewGameFragmentToSpaceShipOneFragment()

            findNavController().navigate(action)
        }

        binding.goBackMenuButton.setOnClickListener {
            val action = JoinNewGameFragmentDirections.actionJoinNewGameFragmentToMenuFragment()

            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}
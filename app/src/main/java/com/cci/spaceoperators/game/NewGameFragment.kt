package com.cci.spaceoperators.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cci.spaceoperators.HistoryFragmentDirections
import com.cci.spaceoperators.databinding.FragmentHistoryBinding
import com.cci.spaceoperators.databinding.FragmentNewGameBinding
import com.cci.spaceoperators.users.User
import com.cci.spaceoperators.users.UserAdapter
import com.cci.spaceoperators.utils.SocketViewModel

class NewGameFragment: Fragment() {

    private var _binding: FragmentNewGameBinding? = null
    private lateinit var binding: FragmentNewGameBinding

    private val socketViewModel: SocketViewModel by viewModels()

    val players = listOf<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewGameBinding.inflate(inflater, container, false)
        binding = _binding!!

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.playerRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.playerRecyclerView.adapter = UserAdapter(players)

        socketViewModel.ipAddress.observe(viewLifecycleOwner) { ip ->
            binding.hostIpAdress.text = "Votre Adresse IP : $ip"
        }

        binding.hostPort.text = "Votre numéro de port : " + socketViewModel.serverSocket.localPort

        binding?.startNewGameButton?.setOnClickListener {
            val action = NewGameFragmentDirections.actionNewGameFragmentToSpaceShipOneFragment()

            findNavController().navigate(action)
        }

        binding.goBackMenuButton.setOnClickListener {
            val action = NewGameFragmentDirections.actionNewGameFragmentToMenuFragment()

            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}
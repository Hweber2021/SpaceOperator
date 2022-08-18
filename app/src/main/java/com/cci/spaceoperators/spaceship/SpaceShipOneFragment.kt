package com.cci.spaceoperators.spaceship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cci.spaceoperators.databinding.FragmentMenuBinding
import com.cci.spaceoperators.databinding.FragmentSpaceShipOneBinding

class SpaceShipOneFragment: Fragment() {

    private var binding: FragmentSpaceShipOneBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpaceShipOneBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnLeftNav?.setOnClickListener {
            val action = SpaceShipOneFragmentDirections.actionSpaceShipOneFragmentToSpaceshipTwoFragment()

            findNavController().navigate(action)
        }

        binding?.btnRightNav?.setOnClickListener {
            val action = SpaceShipOneFragmentDirections.actionSpaceShipOneFragmentToSpaceshipThreeFragment()

            findNavController().navigate(action)
        }

    }

    

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }



}
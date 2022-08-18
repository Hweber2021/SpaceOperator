package com.cci.spaceoperators.spaceship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cci.spaceoperators.SpaceshipTwoFragmentDirections
import com.cci.spaceoperators.databinding.FragmentSpaceShipOneBinding
import com.cci.spaceoperators.databinding.FragmentSpaceshipTwoBinding

class SpaceShipTwoFragment: Fragment() {

    private var binding: FragmentSpaceshipTwoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpaceshipTwoBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnNavMainLeft?.setOnClickListener {
            val action = SpaceshipTwoFragmentDirections.actionSpaceshipTwoFragmentToSpaceShipOneFragment()

            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
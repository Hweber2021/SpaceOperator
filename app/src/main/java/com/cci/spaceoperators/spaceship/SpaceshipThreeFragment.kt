package com.cci.spaceoperators.spaceship

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cci.spaceoperators.databinding.FragmentSpaceShipOneBinding
import com.cci.spaceoperators.databinding.FragmentSpaceshipThreeBinding
import com.cci.spaceoperators.databinding.FragmentSpaceshipTwoBinding

class SpaceshipThreeFragment: Fragment() {

    private var binding: FragmentSpaceshipThreeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpaceshipThreeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnNavMainRight?.setOnClickListener {
            val action = SpaceshipThreeFragmentDirections.actionSpaceshipThreeFragmentToSpaceShipOneFragment()

            findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
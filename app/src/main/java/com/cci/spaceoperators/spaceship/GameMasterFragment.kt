package com.cci.spaceoperators.spaceship

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cci.spaceoperators.databinding.FragmentGameMasterBinding
import com.cci.spaceoperators.databinding.FragmentMenuBinding

class GameMasterFragment: Fragment(){

    private var binding: FragmentGameMasterBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameMasterBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // time count down for 30 seconds,
        // with 1 second as countDown interval
        object : CountDownTimer(60000, 1000) {

            // Callback function, fired on regular interval
            override fun onTick(millisUntilFinished: Long) {
                binding?.textView?.setText("seconds remaining: " + millisUntilFinished / 1000)
            }

            // Callback function, fired
            // when the time is up
            override fun onFinish() {
                binding?.textView?.setText("done!")
            }
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
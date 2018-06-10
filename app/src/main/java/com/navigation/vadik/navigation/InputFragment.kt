package com.navigation.vadik.navigation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_input.*

class InputFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btRegister.setOnClickListener {
            it.findNavController().navigate(R.id.action_from_input_to_details, createUserBundle())
        }
    }

    private fun createUserBundle(): Bundle {
        val userBundle = Bundle()
        userBundle.putString("userName", etUser.text.toString())
        return userBundle
    }
}

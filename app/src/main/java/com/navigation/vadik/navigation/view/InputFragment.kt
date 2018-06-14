package com.navigation.vadik.navigation.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.navigation.vadik.navigation.R

class InputFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userBundle = Bundle()
        userBundle.putString("userName", view.findViewById<EditText>(R.id.etUser).text.toString())

        view.findViewById<Button>(R.id.btRegister).setOnClickListener {
            it.findNavController().navigate(R.id.action_from_input_to_details, userBundle)
        }
    }
}

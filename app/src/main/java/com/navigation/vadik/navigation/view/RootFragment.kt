package com.navigation.vadik.navigation.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.navigation.vadik.navigation.R


class RootFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_root, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btInput).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_from_root_to_input))
        view.findViewById<Button>(R.id.btSettings).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_from_root_to_settings))
    }
}

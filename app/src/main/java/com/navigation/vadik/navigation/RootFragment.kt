package com.navigation.vadik.navigation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_root.*

class RootFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_root, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btInput.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_from_root_to_input))
        btSettings.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_from_root_to_settings))
    }
}

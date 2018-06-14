package com.navigation.vadik.navigation.view.settings


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.navigation.vadik.navigation.R
import com.navigation.vadik.navigation.data.User
import com.navigation.vadik.navigation.view_model.UsersViewModel

class SettingsFragment : Fragment() {
    private val usersViewModel: UsersViewModel by lazy { ViewModelProviders.of(this).get(UsersViewModel::class.java) }

    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        userAdapter = UserAdapter()
        view.findViewById<RecyclerView>(R.id.rvUsers).layoutManager = linearLayoutManager
        view.findViewById<RecyclerView>(R.id.rvUsers).adapter = userAdapter
        usersViewModel.userList.observe(this, Observer<PagedList<User>> { userAdapter.submitList(it) })
        initAdapter()
    }

    private fun initAdapter() {
    }
}

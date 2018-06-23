package com.navigation.vadik.navigation.view.settings


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
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
import com.navigation.vadik.navigation.db.UserEntity
import com.navigation.vadik.navigation.db.UsersDatabase
import com.navigation.vadik.navigation.network.GithubService
import com.navigation.vadik.navigation.repository.UserRepositoryImpl
import com.navigation.vadik.navigation.view_model.UsersViewModel

class SettingsFragment : Fragment() {
    private lateinit var usersViewModel: UsersViewModel

    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.usersViewModel = getViewModel()

        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        userAdapter = UserAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvUsers)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = userAdapter
        usersViewModel.userList.observe(this, Observer<PagedList<UserEntity>> { userAdapter.submitList(it) })
    }

    private fun getViewModel(): UsersViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val db = UsersDatabase.create(requireContext())
                val service = GithubService.getService()
                val repository = UserRepositoryImpl(db, service)
                @Suppress("UNCHECKED_CAST")
                return UsersViewModel(repository) as T
            }
        })[UsersViewModel::class.java]
    }
}

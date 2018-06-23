package com.navigation.vadik.navigation.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.navigation.vadik.navigation.db.UserEntity
import com.navigation.vadik.navigation.db.UsersDatabase
import com.navigation.vadik.navigation.network.GithubService

class UserRepositoryImpl(val db: UsersDatabase,
                         private val githubService: GithubService) : UserRepository {
    companion object {
        private const val DEFAULT_NETWORK_PAGE_SIZE = 10
    }

    override fun loadUsers(): LiveData<PagedList<UserEntity>> {
        val boundaryCallback = UsersBoundaryCallback(
                githubService,
                handleResponse = { insertResultIntoDb(it) },
                networkPageSize = DEFAULT_NETWORK_PAGE_SIZE)
        val dataSourceFactory = db.users().allUsers()
        val builder = LivePagedListBuilder(dataSourceFactory, DEFAULT_NETWORK_PAGE_SIZE)
                .setBoundaryCallback(boundaryCallback)
        return builder.build()
    }

    private fun insertResultIntoDb(users: List<UserEntity>) {
        db.runInTransaction { db.users().insert(users) }
    }
}
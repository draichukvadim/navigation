package com.navigation.vadik.navigation.repository

import android.arch.paging.PagedList
import com.navigation.vadik.navigation.db.UserEntity
import com.navigation.vadik.navigation.network.GithubService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UsersBoundaryCallback(private val githubService: GithubService,
                            private val handleResponse: (List<UserEntity>) -> Unit,
                            private val networkPageSize: Int)
    : PagedList.BoundaryCallback<UserEntity>() {

    override fun onZeroItemsLoaded() {
        githubService
                .getUsers(1, networkPageSize)
                .subscribeOn(Schedulers.newThread())
                .subscribe({ handleResponse(it) }, { it.printStackTrace() })
    }

    override fun onItemAtEndLoaded(itemAtEnd: UserEntity) {
        githubService
                .getUsers(itemAtEnd.id, networkPageSize)
                .subscribeOn(Schedulers.newThread())
                .subscribe({ handleResponse(it) }, { it.printStackTrace() })
    }
}
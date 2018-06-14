package com.navigation.vadik.navigation.data

import android.arch.paging.ItemKeyedDataSource
import com.navigation.vadik.navigation.network.GithubService
import io.reactivex.disposables.CompositeDisposable

class UsersDataSource(
        private val githubService: GithubService,
        private val compositeDisposable: CompositeDisposable)
    : ItemKeyedDataSource<Long, User>() {

    override fun loadInitial(params: LoadInitialParams<Long>, callback: LoadInitialCallback<User>) {
        compositeDisposable.add(
                githubService
                        .getUsers(1, params.requestedLoadSize)
                        .subscribe({ users -> callback.onResult(users) },
                                { throwable -> throwable.printStackTrace() }))
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<User>) {
        compositeDisposable.add(
                githubService
                        .getUsers(params.key, params.requestedLoadSize)
                        .subscribe({ users -> callback.onResult(users) },
                                { throwable -> throwable.printStackTrace() }))
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<User>) {
    }

    override fun getKey(item: User): Long {
        val id = item.id
        if (id == null)
            return 0L
        else return id
    }

}
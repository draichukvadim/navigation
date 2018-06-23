package com.navigation.vadik.navigation.view_model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.navigation.vadik.navigation.db.UserEntity
import com.navigation.vadik.navigation.repository.UserRepository
import io.reactivex.disposables.CompositeDisposable

class UsersViewModel(val repository: UserRepository) : ViewModel() {
    var userList: LiveData<PagedList<UserEntity>>
    private val compositeDisposable = CompositeDisposable()

    init {
        userList = repository.loadUsers()
    }

//    private fun createDataSourceFactory() =
//            UsersDataSourceFactory(compositeDisposable, GithubService.getService())
//
//    private fun createConfig(): PagedList.Config =
//            PagedList.Config.Builder()
//                    .setPageSize(pageSize)
//                    .setInitialLoadSizeHint(pageSize * 2)
//                    .setEnablePlaceholders(false)
//                    .build()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
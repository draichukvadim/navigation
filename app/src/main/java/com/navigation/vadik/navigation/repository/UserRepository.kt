package com.navigation.vadik.navigation.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.navigation.vadik.navigation.db.UserEntity
import io.reactivex.Observable

interface UserRepository {
    fun loadUsers(): LiveData<PagedList<UserEntity>>
}
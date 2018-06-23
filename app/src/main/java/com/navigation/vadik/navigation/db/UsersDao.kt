package com.navigation.vadik.navigation.db

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<UserEntity>)

    @Query("SELECT * FROM users")
    fun allUsers(): DataSource.Factory<Int, UserEntity>
}
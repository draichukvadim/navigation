package com.navigation.vadik.navigation.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(UserEntity::class),
        version = 1,
        exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {
    companion object {
        fun create(context: Context): UsersDatabase {
            return Room.databaseBuilder(context, UsersDatabase::class.java, "users.db")
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }

    abstract fun users(): UsersDao
}
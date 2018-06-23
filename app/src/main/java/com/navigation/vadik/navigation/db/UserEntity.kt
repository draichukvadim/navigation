package com.navigation.vadik.navigation.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users",
        indices = [(Index(value = ["id"], unique = false))])
data class UserEntity(
        @PrimaryKey @SerializedName("id") // this seems mutable but fine for a demo
        @ColumnInfo(collate = ColumnInfo.NOCASE)
        val id: Long,

        @SerializedName("login")
        val login: String
)
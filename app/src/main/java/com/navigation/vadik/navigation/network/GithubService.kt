package com.navigation.vadik.navigation.network

import com.navigation.vadik.navigation.data.User
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("/users")
    fun getUsers(@Query("since") sinceUserId: Long, @Query("per_page") perPage: Int): Single<List<User>>

    companion object {
        fun getService(): GithubService {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(GithubService::class.java)
        }
    }
}
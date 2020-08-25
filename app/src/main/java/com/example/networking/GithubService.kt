package com.example.networking

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface GithubService {

    @GET("users")
    suspend fun getUsers() : Response<List<User>>

    @GET("users/{id}")
    suspend fun getUser(@Path("id")id:String) : Response<User>

    @GET("users/user")
    suspend fun searchUser(@Query("q")query: String) : Response<List<User>>
}
package com.bootcampinter.apprepositories.data.services

import com.bootcampinter.apprepositories.data.model.UserGit
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepositories(@Path("user") user: String) : List<UserGit>
}
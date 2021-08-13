package com.bootcampinter.apprepositories.data.repositories

import com.bootcampinter.apprepositories.data.model.UserGit
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun listRepositories(user: String): Flow<List<UserGit>>
}
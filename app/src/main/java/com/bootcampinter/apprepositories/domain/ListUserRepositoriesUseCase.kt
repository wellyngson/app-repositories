package com.bootcampinter.apprepositories.domain

import com.bootcampinter.apprepositories.core.UseCase
import com.bootcampinter.apprepositories.data.model.UserGit
import com.bootcampinter.apprepositories.data.repositories.Repository
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(
    private val repository: Repository
) : UseCase<String, List<UserGit>>() {

    override suspend fun execute(param: String): Flow<List<UserGit>> {
        return repository.listRepositories(param)
    }
}
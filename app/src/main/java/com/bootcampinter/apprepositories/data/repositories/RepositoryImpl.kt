package com.bootcampinter.apprepositories.data.repositories

import com.bootcampinter.apprepositories.core.RemoteException
import com.bootcampinter.apprepositories.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepositoryImpl(private val service: GitHubService) : Repository {

    override suspend fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possivel fazer a busca no momento!")
        }
    }
}
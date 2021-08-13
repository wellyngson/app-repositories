package com.bootcampinter.apprepositories.data.model

import com.google.gson.annotations.SerializedName

data class UserGit(
    val id: Long,
    val name: String,
    val owner: Owner,
    @SerializedName("stargazers_count")
    val stargazersCount: Long,
    val language: String,
    @SerializedName("html_url")
    val htmlURL: String,
    val description: String
)
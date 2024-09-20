package com.example.myapplication.domain.api

import com.vk.id.AccessToken

interface SaveTokenUseCase {
    fun saveToken(accessToken: AccessToken)
}
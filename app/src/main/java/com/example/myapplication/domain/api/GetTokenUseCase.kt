package com.example.myapplication.domain.api

import com.vk.id.AccessToken

interface GetTokenUseCase {
    fun getToken(): AccessToken?
}
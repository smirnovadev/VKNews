package com.example.myapplication.domain.api

import com.vk.id.AccessToken

interface LocalStorageRepository {
    fun getToken(): AccessToken?
    fun saveToken(accessToken: AccessToken)
}
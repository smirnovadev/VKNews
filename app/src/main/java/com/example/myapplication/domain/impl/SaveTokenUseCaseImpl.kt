package com.example.myapplication.domain.impl

import com.example.myapplication.domain.api.LocalStorageRepository
import com.example.myapplication.domain.api.SaveTokenUseCase
import com.vk.id.AccessToken

class SaveTokenUseCaseImpl(
    private val localStorageRepository: LocalStorageRepository
): SaveTokenUseCase {
    override fun saveToken(accessToken: AccessToken) {
        localStorageRepository.saveToken(accessToken)
    }
}
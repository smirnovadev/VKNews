package com.example.myapplication.domain.impl

import com.example.myapplication.domain.api.GetTokenUseCase
import com.example.myapplication.domain.api.LocalStorageRepository
import com.vk.id.AccessToken

class GetTokenUseCaseImpl(
    private val localStorageRepository: LocalStorageRepository,
): GetTokenUseCase {
    override fun getToken(): AccessToken? {
        return localStorageRepository.getToken()
    }
}

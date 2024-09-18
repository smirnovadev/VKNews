package com.example.myapplication.domain.impl

import com.example.myapplication.domain.api.GetTokenUseCase
import com.example.myapplication.domain.api.LocalStorageRepository

class GetTokenUseCaseImpl(
    private val localStorageRepository: LocalStorageRepository,
): GetTokenUseCase {
    override fun getToken(): String? {
        return localStorageRepository.getToken()
    }
}

package com.example.myapplication.domain.impl

import com.example.myapplication.domain.api.LocalStorageRepository
import com.example.myapplication.domain.api.SaveTokenUseCase

class SaveTokenUseCaseImpl(
    private val localStorageRepository: LocalStorageRepository
): SaveTokenUseCase {
    override fun saveToken(token: String) {
        localStorageRepository.saveToken(token)
    }
}
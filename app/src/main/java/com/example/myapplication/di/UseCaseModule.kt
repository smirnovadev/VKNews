package com.example.myapplication.di

import com.example.myapplication.domain.api.GetTokenUseCase
import com.example.myapplication.domain.api.SaveTokenUseCase
import com.example.myapplication.domain.impl.GetTokenUseCaseImpl
import com.example.myapplication.domain.impl.SaveTokenUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetTokenUseCase> {
        GetTokenUseCaseImpl(get())
    }
    single<SaveTokenUseCase> {
        SaveTokenUseCaseImpl(get())
    }
}
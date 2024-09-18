package com.example.myapplication.di

import com.example.myapplication.data.LocalStorageRepositoryImpl
import com.example.myapplication.domain.api.LocalStorageRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<LocalStorageRepository> {
        LocalStorageRepositoryImpl(get())
    }
}
package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.dataModule
import com.example.myapplication.di.repositoryModule
import com.example.myapplication.di.useCaseModule
import com.example.myapplication.di.viewModelModule
import com.vk.id.VKID
import org.koin.android.ext.koin.androidContext

import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(
                dataModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            ))
        }
        VKID.init(this)


    }
}
package com.example.myapplication.di

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { Gson() }

    single<SharedPreferences> {
        androidContext()
            .getSharedPreferences("pref_access_token", Context.MODE_PRIVATE)
    }

}

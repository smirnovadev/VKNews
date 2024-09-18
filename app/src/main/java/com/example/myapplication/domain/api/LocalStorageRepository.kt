package com.example.myapplication.domain.api

interface LocalStorageRepository {
    fun getToken(): String?
    fun saveToken(accessToken: String)
}
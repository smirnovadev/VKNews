package com.example.myapplication.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.api.GetTokenUseCase
import com.example.myapplication.domain.api.SaveTokenUseCase
import com.vk.id.AccessToken

class MainViewModel(
    private val getTokenUseCase: GetTokenUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {

    private val _authState = MutableLiveData<AuthState>(AuthState.Initial)
    val authState: LiveData<AuthState> = _authState

    init {
        val accessToken = getAccessToken()
        _authState.value = if (accessToken != null && isTokenValid(accessToken)) {
            AuthState.Authorized
        } else {
            AuthState.NotAuthorized
        }
    }
    private fun isTokenValid(accessToken: AccessToken): Boolean {
        return accessToken.expireTime == -1L || accessToken.expireTime > System.currentTimeMillis()
    }
    private fun getAccessToken(): AccessToken? {
        val token = getTokenUseCase.getToken()
        return token
    }
   fun saveToken(accessToken: AccessToken) {
        saveTokenUseCase.saveToken(accessToken)
    }

}

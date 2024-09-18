package com.example.myapplication.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.domain.api.GetTokenUseCase
import com.example.myapplication.domain.api.SaveTokenUseCase

class MainViewModel(
    private val getTokenUseCase: GetTokenUseCase,
    private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {

    private val _authState = MutableLiveData<AuthState>(AuthState.Initial)
    val authState: LiveData<AuthState> = _authState

    init {
        val token = getAccessToken()
        _authState.value = if (token != null) {
            AuthState.Authorized
        } else {
            AuthState.NotAuthorized
        }
    }

    private fun getAccessToken(): String? {
        val token = getTokenUseCase.getToken()
        return token
    }
    fun saveToken(token: String) {
        saveTokenUseCase.saveToken(token)
    }

}

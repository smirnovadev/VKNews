package com.example.myapplication.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vk.id.AccessToken

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _authState = MutableLiveData<AuthState>(AuthState.Initial)
    val authState: LiveData<AuthState> = _authState

    init {
        _authState.value = if (false) {
            AuthState.Authorized
        } else {
            AuthState.NotAuthorized
        }
    }

    fun saveAccessToken(token: AccessToken) {
        //TODO (save token shared pref)
    }
}

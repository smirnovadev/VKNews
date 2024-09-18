package com.example.myapplication.data

import android.content.SharedPreferences
import com.example.myapplication.domain.api.LocalStorageRepository

class LocalStorageRepositoryImpl(
    private val sharedPref: SharedPreferences,

    ) : LocalStorageRepository {

    override fun saveToken(token: String) {
        val editor = sharedPref.edit()
        editor.putString(KEY_ACCESS_TOKEN, token)
        editor.apply()
    }

    override fun getToken(): String? {

        return sharedPref.getString(KEY_ACCESS_TOKEN, null)

    }

    companion object {
        private const val KEY_ACCESS_TOKEN = "key_access_token"
    }
}
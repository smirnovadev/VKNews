package com.example.myapplication.data

import android.content.SharedPreferences
import com.example.myapplication.domain.api.LocalStorageRepository
import com.google.gson.Gson
import com.vk.id.AccessToken

class LocalStorageRepositoryImpl(
    private val sharedPref: SharedPreferences,
    private val gson: Gson

    ) : LocalStorageRepository {

    override fun saveToken(accessToken: AccessToken) {
        val editor = sharedPref.edit()
        val json = gson.toJson(accessToken)
        editor.putString(KEY_ACCESS_TOKEN, json)
        editor.apply()
    }

    override fun getToken(): AccessToken? {
        val json = sharedPref.getString(KEY_ACCESS_TOKEN, null)
        return if (json != null) {
            gson.fromJson(json, AccessToken::class.java)
        } else {
            null
        }
    }

    companion object {
        private const val KEY_ACCESS_TOKEN = "key_access_token"
    }
}
package com.example.myapplication.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.livedata.observeAsState
import com.example.myapplication.theme.MyApplicationTheme
import com.vk.id.AccessToken
import com.vk.id.onetap.common.OneTapOAuth
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.d("MainScreen", "Main ScreenOpen")
            MyApplicationTheme {
                val viewModel: MainViewModel = getViewModel()
                val authState = viewModel.authState.observeAsState(AuthState.Initial)
                when (authState.value) {
                    is AuthState.Authorized -> {
                        Log.d("MainScreen", "AuthState.Authorized")
                        MainScreen()
                    }

                    is AuthState.NotAuthorized -> {
                        Log.d("MainScreen", "NotAuthorized")
                        LoginScreen(onAuth = { oAuth: OneTapOAuth?, accessToken: AccessToken ->
                            Log.d(
                                "MainScreen",
                                "Successfully authorized with token: ${accessToken.token}"
                            )
                            viewModel.saveToken(accessToken)
                            Log.d("MainScreen", "savetoken:  ${accessToken.token} ")

                        })
                    }

                    is AuthState.Initial -> {
                        Log.d("MainScreen", "else")
                    }
                }
            }
        }
    }
}

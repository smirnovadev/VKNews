package com.example.myapplication.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.theme.MyApplicationTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.d("MainScreen", "Main ScreenOpen")
            MyApplicationTheme {
                val viewModel: MainViewModel = viewModel()
                val authState = viewModel.authState.observeAsState(AuthState.Initial)
                val launcher =
                    rememberLauncherForActivityResult(
                        contract = VK.getVKAuthActivityResultContract()
                    ) { result ->
                        Log.d("MainScreen", "viewModel.performAuthResult(it)")
                        viewModel.performAuthResult(result)
                    }
                when (authState.value) {
                    is AuthState.Authorized -> {
                        Log.d("MainScreen", "AuthState.Authorized")
                        MainScreen()
                    }

                    is AuthState.NotAuthorized -> {
                        Log.d("MainScreen", "NotAuthorized")
                        LoginScreen (onLoginClick = {
                            launcher.launch(listOf(VKScope.WALL, VKScope.FRIENDS))
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


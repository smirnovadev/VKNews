package com.example.myapplication.presentation.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.vk.id.AccessToken
import com.vk.id.VKIDAuthFail
import com.vk.id.auth.VKIDAuthUiParams
import com.vk.id.onetap.common.OneTapOAuth
import com.vk.id.onetap.compose.onetap.OneTap

@Composable
fun LoginScreen(
    onAuth: (OneTapOAuth?, AccessToken) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.wrapContentHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.ic_vk_logo),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(100.dp))
            OneTap(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                onAuth = onAuth,
                authParams = VKIDAuthUiParams {
                    scopes = setOf("wall", "friends")
                },
                onFail = { oAuth, fail ->
                    when (fail) {
                        is VKIDAuthFail.Canceled -> Log.d(
                            "MainScreen",
                            "Authorization canceled by user."
                        )

                        is VKIDAuthFail.FailedApiCall -> Log.d("MainScreen", "API call failed.")
                        is VKIDAuthFail.FailedOAuthState -> Log.d(
                            "MainScreen",
                            "Failed OAuth state."
                        )

                        is VKIDAuthFail.FailedRedirectActivity -> Log.d(
                            "MainScreen",
                            "Failed redirect."
                        )

                        is VKIDAuthFail.NoBrowserAvailable -> Log.d(
                            "MainScreen",
                            "No browser available."
                        )

                        is VKIDAuthFail.FailedOAuth -> Log.d("MainScreen", "Failed OAuth.")
                    }
                }
            )
        }
    }
}
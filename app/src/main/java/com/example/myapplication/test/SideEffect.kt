package com.example.myapplication.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SideEffect(number: MyNumber) {
    Column {
        LazyColumn{
            repeat(5) {
                item {
                    Text(text = "Number: ${number.a}")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        android.os.Handler().postDelayed({
            number.a = 5
        }, 3000)

        LazyColumn{
            repeat(5) {
                item {
                    Text(text = "Number: ${number.a}")
                }
            }
        }
    }



}

data class MyNumber(var a : Int)
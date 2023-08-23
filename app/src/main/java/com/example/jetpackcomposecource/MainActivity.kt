package com.example.jetpackcomposecource

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecource.ui.theme.JetPackComposeCourceTheme
import com.example.jetpackcomposecource.ui.vk.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeCourceTheme(
                dynamicColor = false
            ) {
                MainScreen()
            }
        }
    }
}

@Preview
@Composable
fun Test() {
    JetPackComposeCourceTheme(
        dynamicColor = false
    ) {
        MainScreen()
    }
}
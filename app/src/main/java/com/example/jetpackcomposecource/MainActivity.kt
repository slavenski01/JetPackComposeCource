package com.example.jetpackcomposecource

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.jetpackcomposecource.ui.theme.JetPackComposeCourceTheme
import com.example.jetpackcomposecource.ui.vk.MainScreen
import com.example.jetpackcomposecource.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeCourceTheme(
                dynamicColor = false
            ) {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}
package com.example.jetpackcomposecource

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.jetpackcomposecource.ui.instagram.InstagramCard
import com.example.jetpackcomposecource.ui.theme.JetPackComposeCourceTheme
import com.example.jetpackcomposecource.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeCourceTheme(
                dynamicColor = false
            ) {
                Test(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun Test(viewModel: MainViewModel) {
    JetPackComposeCourceTheme(
        dynamicColor = false
    ) {
        LazyColumn {
            repeat(100) {
                item {
                    InstagramCard(viewModel = viewModel)
                }
            }
        }
    }
}
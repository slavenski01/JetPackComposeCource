package com.example.jetpackcomposecource

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecource.ui.instagram.InstagramCard
import com.example.jetpackcomposecource.ui.theme.JetPackComposeCourceTheme
import com.example.jetpackcomposecource.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeCourceTheme(
                dynamicColor = false
            ) {
                val models = viewModel.models.observeAsState(listOf())
                LazyColumn {
                    items(models.value, key = { it.id }) {
                        val dismissState = rememberDismissState()

                        if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                            viewModel.deleteInstaModel(model = it)
                        }
                        SwipeToDismiss(
                            state = dismissState,
                            directions = setOf(DismissDirection.EndToStart),
                            dismissContent = {
                                InstagramCard(
                                    model = it,
                                    onIsFollowedClick = { clickItem ->
                                        viewModel.changeFollowingStatus(clickItem)
                                    }
                                )
                            },
                            background = {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp)
                                        .background(Color.Red.copy(alpha = 0.5f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        modifier = Modifier.padding(16.dp),
                                        text = "DeleteItem",
                                        fontSize = 24.sp,
                                        color = Color.White
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}
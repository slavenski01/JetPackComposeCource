package com.example.jetpackcomposecource.ui.vk

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecource.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val snackBarHostState = SnackbarHostState()
    val scope = rememberCoroutineScope()
    val fabIsVisible = remember { mutableStateOf(true) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                val selectedItemPosition = remember {
                    mutableIntStateOf(0)
                }

                val bottomButtons = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile,
                )
                bottomButtons.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedItemPosition.intValue,
                        onClick = { selectedItemPosition.intValue = index },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = item.title) },
                    )
                }
            }
        },
        floatingActionButton = {
            if (fabIsVisible.value) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val action = snackBarHostState.showSnackbar(
                                message = "This is snackBar",
                                actionLabel = "Hide FAB",
                                duration = SnackbarDuration.Long
                            )

                            if (action == SnackbarResult.ActionPerformed) {
                                fabIsVisible.value = false
                            }
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null
                    )
                }
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }
    ) {
        val feedNews = viewModel.feedNews.observeAsState(listOf())
        LazyColumn {
            items(feedNews.value, key = { it.id }) { feed ->

                val dismissState = rememberDismissState()

                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                    viewModel.removeVkItem(feed)
                }

                SwipeToDismiss(
                    state = dismissState,
                    directions = setOf(DismissDirection.EndToStart),
                    dismissContent = {
                        VKCard(
                            feedNews = feed,
                            onViewsClickListener = {
                                viewModel.updateVkStatCount(item = feed, statisticItem = it)
                            },
                            onCommentClickListener = {
                                viewModel.updateVkStatCount(item = feed, statisticItem = it)
                            },
                            onShareClickListener = {
                                viewModel.updateVkStatCount(item = feed, statisticItem = it)
                            },
                            onLikeClickListener = {
                                viewModel.updateVkStatCount(item = feed, statisticItem = it)
                            },
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
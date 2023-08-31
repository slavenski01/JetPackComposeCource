package com.example.jetpackcomposecource.ui.vk

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.jetpackcomposecource.domain.NewsComment
import com.example.jetpackcomposecource.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel
) {
    val feedNews = viewModel.feedNews.observeAsState(listOf())
    val comments = mutableListOf<NewsComment>().apply {
        repeat(20) {
            add(NewsComment(it))
        }
    }
    CommentsScreen(
        feedNews = feedNews.value[0],
        comments = comments
    )
//    LazyColumn(
//        contentPadding = PaddingValues(
//            start = 8.dp,
//            top = 16.dp,
//            end = 8.dp,
//            bottom = 80.dp
//        ),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(items = feedNews.value, key = { it.id }) { feed ->
//            val dismissState = rememberDismissState()
//
//            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
//                viewModel.removeVkItem(feed)
//            }
//
//            SwipeToDismiss(
//                modifier = Modifier.animateItemPlacement(),
//                state = dismissState,
//                directions = setOf(DismissDirection.EndToStart),
//                dismissContent = {
//                    VKCard(
//                        feedNews = feed,
//                        onViewsClickListener = {
//                            viewModel.updateVkStatCount(item = feed, statisticItem = it)
//                        },
//                        onCommentClickListener = {
//                            viewModel.updateVkStatCount(item = feed, statisticItem = it)
//                        },
//                        onShareClickListener = {
//                            viewModel.updateVkStatCount(item = feed, statisticItem = it)
//                        },
//                        onLikeClickListener = {
//                            viewModel.updateVkStatCount(item = feed, statisticItem = it)
//                        },
//                    )
//                },
//                background = {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(16.dp)
//                            .background(Color.Red.copy(alpha = 0.5f)),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            modifier = Modifier.padding(16.dp),
//                            text = "DeleteItem",
//                            fontSize = 24.sp,
//                            color = Color.White
//                        )
//                    }
//                }
//            )
//        }
//    }
}
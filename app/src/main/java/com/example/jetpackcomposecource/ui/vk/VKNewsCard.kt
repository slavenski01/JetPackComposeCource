package com.example.jetpackcomposecource.ui.vk

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecource.R
import com.example.jetpackcomposecource.domain.FeedNews
import com.example.jetpackcomposecource.domain.StatisticItem
import com.example.jetpackcomposecource.domain.StatisticType

@Composable
fun VKCard(
    feedNews: FeedNews,
    onViewsClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
    onLikeClickListener: (StatisticItem) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.background
        ),
        border = BorderStroke(0.1.dp, Color.Black),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        VKHeader(feedNews = feedNews)
        VKBody(feedNews = feedNews)
        VKFooter(
            statistics = feedNews.statistics,
            onLikeClickListener = onLikeClickListener,
            onCommentClickListener = onCommentClickListener,
            onShareClickListener = onShareClickListener,
            onViewsClickListener = onViewsClickListener
        )
    }
}

@Composable
private fun VKHeader(
    feedNews: FeedNews
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = feedNews.communityName,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = feedNews.publicationDate,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            modifier = Modifier
                .size(25.dp),
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSecondary
        )

    }
}

@Composable
private fun VKBody(feedNews: FeedNews) {
    Column(modifier = Modifier.padding(all = 8.dp)) {
        Text(
            text = "text from ${feedNews.id}: ${feedNews.contentText}",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillBounds,
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = ""
        )
    }
}

@Composable
private fun VKFooter(
    statistics: List<StatisticItem>,
    onViewsClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
    onLikeClickListener: (StatisticItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val viewsItem = statistics.getItemByType(StatisticType.VIEWS)
        VKBadge(
            modifier = Modifier.weight(1f),
            iconRes = R.drawable.ic_views,
            count = viewsItem.count,
            onItemClickListener = {
                onViewsClickListener(viewsItem)
            }
        )

        val sharesItem = statistics.getItemByType(StatisticType.SHARES)
        VKBadge(
            iconRes = R.drawable.ic_share,
            count = sharesItem.count,
            onItemClickListener = {
                onShareClickListener(sharesItem)
            }
        )

        val commentItem = statistics.getItemByType(StatisticType.COMMENTS)
        VKBadge(
            iconRes = R.drawable.ic_comments,
            count = commentItem.count,
            onItemClickListener = {
                onCommentClickListener(commentItem)
            }
        )

        val likesItem = statistics.getItemByType(StatisticType.LIKES)
        VKBadge(
            iconRes = R.drawable.ic_like,
            count = likesItem.count,
            onItemClickListener = {
                onLikeClickListener(likesItem)
            }
        )

    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType) =
    this.find { it.type == type } ?: throw IllegalStateException()

@Composable
private fun VKBadge(
    modifier: Modifier = Modifier,
    iconRes: Int,
    count: Int,
    onItemClickListener: () -> Unit
) {
    Row(
        modifier = modifier
            .clickable {
                onItemClickListener()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .padding(8.dp),
            painter = painterResource(iconRes),
            contentDescription = ""
        )
        Text(
            modifier = modifier.padding(4.dp),
            text = count.toString()
        )
    }
}
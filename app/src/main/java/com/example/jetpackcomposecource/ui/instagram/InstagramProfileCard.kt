package com.example.jetpackcomposecource.ui.instagram

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecource.R
import com.example.jetpackcomposecource.domain.InstagramModel

@Composable
fun InstagramCard(
    model: InstagramModel,
    onIsFollowedClick: (InstagramModel) -> Unit
) {

    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        val subInfoList = listOf(
            Pair("6,950", "Posts"),
            Pair("436M", "Followers"),
            Pair("76", "Following"),
        )
        Card(
            shape = RoundedCornerShape(
                topStart = 8.dp,
                topEnd = 8.dp
            ),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(8.dp),
                        painter = painterResource(id = R.drawable.ic_instagram_logo),
                        contentDescription = ""
                    )

                    subInfoList.forEach {
                        SubsInfo(countString = it.first, name = it.second)
                    }
                }
                BodyCard(model = model) {
                    onIsFollowedClick(model)
                }
            }
        }
    }
}

@Composable
private fun SubsInfo(countString: String, name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box {
            Text(
                text = countString,
                fontSize = 24.sp,
                fontFamily = FontFamily.Cursive
            )
        }
        Box {
            Text(
                text = name,
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun BodyCard(
    model: InstagramModel,
    clickListener: () -> Unit
) {
    Column {
        Text(
            text = "Instagram ${model.id}",
            fontFamily = FontFamily.Cursive,
            fontSize = 36.sp
        )
        Text(
            text = "#${model.title}"
        )
        Text(text = "www.facebook.com")
        FollowButton(isFollowed = model.isFollowed) {
            clickListener()
        }
    }
}

@Composable
private fun FollowButton(
    isFollowed: Boolean,
    clickListener: () -> Unit
) {
    Button(
        onClick = { clickListener() },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFollowed) {
                MaterialTheme.colorScheme.primary.copy(
                    alpha = 0.5f
                )
            } else {
                MaterialTheme.colorScheme.primary
            }
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        val text = if (isFollowed) "unfollow" else "follow"
        Text(text = text)
    }
}
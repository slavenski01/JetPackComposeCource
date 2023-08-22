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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecource.R
import com.example.jetpackcomposecource.ui.theme.JetPackComposeCourceTheme

@Composable
fun InstagramCard() {
    Column {
        ProfileCard(
            subInfoList = listOf(
                Pair("6,950", "Posts"),
                Pair("436M", "Followers"),
                Pair("76", "Following"),
            )
        )
    }
}

@Composable
fun ProfileCard(subInfoList: List<Pair<String, String>>) {
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
            BodyCard()
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
fun BodyCard() {
    Column {
        Text(
            text = "Instagram",
            fontFamily = FontFamily.Cursive,
            fontSize = 36.sp
        )
        Text(
            text = "#YoursToMake"
        )
        Text(text = "www.facebook.com")
        Button(
            onClick = { },
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Follow")
        }
    }
}

@Preview
@Composable
fun InstagramDarkPreview() {
    JetPackComposeCourceTheme(
        darkTheme = true
    ) {
        InstagramCard()
    }
}

@Preview
@Composable
fun InstagramLightPreview() {
    JetPackComposeCourceTheme(
        darkTheme = false
    ) {
        InstagramCard()
    }
}
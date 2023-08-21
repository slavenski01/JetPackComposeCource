package com.example.jetpackcomposecource.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun InstagramCard() {
    HeaderCard(
        subInfoList = listOf(
            Pair("6,950", "Posts"),
            Pair("436M", "Followers"),
            Pair("76", "Following"),
        )
    )
}

@Composable
fun HeaderCard(subInfoList: List<Pair<String, String>>) {
    Card(
        shape = RoundedCornerShape(
            topStart = 8.dp,
            topEnd = 8.dp
        ),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier,
            ) {
                Text(text = "test")
            }

            subInfoList.forEach {
                SubsInfo(countString = it.first, name = it.second)
            }
        }
    }
}

@Composable
private fun SubsInfo(countString: String, name: String) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier,
        ) {
            Text(text = countString)
        }
        Box(
            modifier = Modifier,
        ) {
            Text(
                text = name,
                fontSize = 8.sp
            )
        }
    }
}
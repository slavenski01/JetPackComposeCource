package com.example.jetpackcomposecource.ui.vk

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecource.R
import com.example.jetpackcomposecource.ui.theme.JetPackComposeCourceTheme

@Preview
@Composable
fun VKCard() {
    Card(
        modifier = Modifier
            .padding(6.dp),
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.background
        ),
        border = BorderStroke(0.1.dp, Color.Black),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        VKHeader()
        VKBody()
    }
}

@Composable
fun VKHeader() {
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
                text = "уволено",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "14:00",
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
fun VKBody() {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = "кабаныч, когда узнал, что " +
                    "если сотрудникам не платить",
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
fun VKFooter() {

}

@Preview
@Composable
fun Test() {
    JetPackComposeCourceTheme(
        dynamicColor = false,
        darkTheme = true
    ) {
        VKCard()
    }
}
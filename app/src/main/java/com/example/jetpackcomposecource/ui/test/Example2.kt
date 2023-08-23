@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jetpackcomposecource.ui.test

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Example2() {
    TextField(
        value = "",
        onValueChange = {},
        label = {
            Text(text = "label")
        }
    )
}

@Preview
@Composable
private fun TestExample() {

}
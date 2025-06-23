package com.lucifer.jetpackcomposecourse.`2_FundamentalConcepts`

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showSystemUi = true)
@Composable
fun BasicPreview() {
    Greeting(name = "World")
}
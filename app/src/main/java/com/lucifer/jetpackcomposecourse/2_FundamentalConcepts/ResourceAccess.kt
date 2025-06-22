package com.lucifer.jetpackcomposecourse.`2_FundamentalConcepts`

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.lucifer.jetpackcomposecourse.R


@Composable
fun AccessResource() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            color = colorResource(R.color.purple_500)
        )
    }
}

@Composable
fun AccessImage() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.sample_img),
            contentDescription = null
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ResourceAccessPreview() {
    AccessImage()
}
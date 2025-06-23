package com.lucifer.jetpackcomposecourse.`6_Cards`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * ElevatedCard in Jetpack Compose:
 * - ElevatedCard is a Material Design component that displays content with a shadow, giving a sense of elevation.
 * - Used to group related information and make it stand out from the background.
 * - Supports elevation, shape, and background color customization.
 * - Has rounded corners by default, as defined by the Material theme.
 * - Commonly used for lists, dashboards, or to highlight important content.
 * - Handles click and interaction events, making it suitable for interactive UI elements.
 */
@Composable
fun ElevatedCardSample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ElevatedCard(
            modifier = Modifier.width(200.dp).height(100.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Text(text = "Elevated Card Sample", fontSize = 22.sp,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ElevatedCardPreview() {
    ElevatedCardSample()
}
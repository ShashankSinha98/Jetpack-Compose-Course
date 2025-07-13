package com.lucifer.jetpackcomposecourse.`27_Animation`

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
animateDpAsState is a Jetpack Compose function that animates a Dp (density-independent pixel) value when its target
changes. It smoothly transitions the value from its current state to the new target using a specified animation
specification (like duration and easing). This is useful for creating animated UI effects, such as resizing components
when a state changes.

This line creates an animated value for the box size using Jetpack Compose's animateDpAsState.
- `targetValue`: The size to animate to, which is 200.dp if expanded is true, otherwise 100.dp.
- `animationSpec`: Defines the animation's duration (500ms) and easing curve (FastOutSlowInEasing).
- `label`: A label for debugging and inspection tools.
The `size` value will smoothly transition between 100.dp and 200.dp when `expanded` changes.
 */

@Composable
fun AnimatedBoxSample() {

    var expanded by remember { mutableStateOf(false) }

    val size by animateDpAsState(
        targetValue = if(expanded) 200.dp else 100.dp,
        animationSpec = tween(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        ),
        label = "Box Size Animation"
    )

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Box(modifier = Modifier.size(size)
            .background(Color.Blue).clickable {
                expanded = !expanded
            },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Tap Me", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AnimatedBoxPreview() {
    AnimatedBoxSample()
}
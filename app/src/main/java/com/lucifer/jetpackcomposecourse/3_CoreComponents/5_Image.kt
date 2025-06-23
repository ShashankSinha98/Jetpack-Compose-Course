package com.lucifer.jetpackcomposecourese.`3_CoreComponents`

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucifer.jetpackcomposecourse.R

/**
* Key Differences Between contentScale and Modifier.scale:
*
* 1. **contentScale**:
*    - Controls how the image content is scaled within its bounds.
*    - Maintains or ignores the aspect ratio based on the selected scaling option.
*    - Affects only the image content, not the composable's size or layout.
*    - Common options: ContentScale.Crop, ContentScale.Fit, ContentScale.FillBounds.

* 2. **Modifier.scale**:
*    - Scales the entire composable, including its layout and bounds.
*    - Allows independent scaling along the x-axis and y-axis.
*    - Changes the composable's size and position in the layout.
*    - Example: scale(1f, 1.5f) increases height while keeping width unchanged.
*/
@Composable
fun CircleImageWithBorderSample() {
    val rainbowColors = remember {
        Brush.sweepGradient(
            listOf(
                Color.Red,
                Color.Blue,
                Color.Green,
                Color.Yellow,
                Color.Magenta,
                Color.Cyan,
                Color(0xFFEE82EE) // Violet
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.sample_img),
            contentDescription = null,
            contentScale = ContentScale.Crop, // Ensures the image is cropped to fit the bounds.
            modifier = Modifier
                .size(150.dp) // Sets the size of the image to 150dp by 150dp.
                .clip(CircleShape) // Clips the image into a circular shape.
                .border(
                    border= BorderStroke(
                        width = 2.dp, // Sets the border width to 2dp.
                        brush = rainbowColors, // Uses a gradient brush for the border color.
                    ),
                    shape = CircleShape)
                //.scale(1f, 1.5f) // Scales the image horizontally by 1x (no change) and vertically by 1.5x (increases height).
        )
    }
}

/**
* **RoundedCornerShape**:
* - A shape used to create rounded corners for a composable.
* - Can define uniform corner radii or specify different radii for each corner.
* - Supports both absolute values (e.g., in dp) and percentage-based values.

* Examples:
* 1. RoundedCornerShape(16.dp):
*    - Creates a shape with all corners having a radius of 16dp.

* 2. RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp, bottomStart = 16.dp, bottomEnd = 16.dp):
*    - Creates a shape with custom radii for each corner:
*      - Top start and top end corners have a radius of 8dp.
*      - Bottom start and bottom end corners have a radius of 16dp.

* 3. RoundedCornerShape(percent = 50):
*    - Creates a shape with corner radii based on a percentage of the composable's size.
*    - 50% means the corners will be half the size of the composable.
*/
@Composable
fun RoundedCornerImageSample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.sample_img),
            contentDescription = null,
            contentScale = ContentScale.Crop, // Ensures the image is cropped to fit the bounds.
            modifier = Modifier
                .size(150.dp) // Sets the size of the image to 150dp by 150dp.
                .clip(RoundedCornerShape(16.dp)) // Clips the image into a rounded rectangle shape with 16dp corners.
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun ImagePreview() {
    CircleImageWithBorderSample()
}
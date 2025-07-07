package com.lucifer.jetpackcomposecourse.`18_Slider`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Slider is a Material3 composable that allows users to select a value from a continuous or discrete range.
 *
 * Parameters:
 * - value: The current value of the slider (Float). This determines the thumb's position.
 * - onValueChange: Lambda called when the user moves the slider. Updates the value.
 * - colors: Customizes the colors of the slider components (thumb, track, etc.) using SliderDefaults.colors.
 * - steps: Number of discrete steps between min and max (excluding endpoints). For example, steps = 10 creates 11 positions.
 * - valueRange: The range of allowed values for the slider, specified as a ClosedFloatingPointRange (e.g., 0f..100f).
 */
@Composable
fun SliderSample() {

    var sliderPos by remember {
        mutableFloatStateOf(0f)
    }

    Box(modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Slider(
                value = sliderPos,
                onValueChange = { sliderPos = it },
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colorScheme.secondary,
                    activeTrackColor = MaterialTheme.colorScheme.secondary,
                    inactiveTickColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                steps = 10, // (optional) Number of discrete steps between 0 and 100
                valueRange = 0f..100f
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Current Position: $sliderPos")
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun SliderPreview() {
    SliderSample()
}
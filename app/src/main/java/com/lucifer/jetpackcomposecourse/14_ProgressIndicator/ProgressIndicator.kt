package com.lucifer.jetpackcomposecourse.`14_ProgressIndicator`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun CircularProgressSample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun LinearProgressSample() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LinearProgressIndicator()
    }
}

/**
 * LaunchedEffect is a Jetpack Compose side-effect API used to launch coroutines
 * that are tied to the lifecycle of a composable.
 *
 * Usage:
 * - LaunchedEffect(key1, key2, ...) { ... } runs the coroutine block when the composable
 *   enters the composition or when any of the provided keys change.
 * - If the keys change, the previous coroutine is cancelled and a new one is launched.
 * - Commonly used for starting animations, timers, or performing one-time actions
 *   (such as loading data) when a composable appears.
 * - The coroutine is automatically cancelled when the composable leaves the composition,
 *   preventing memory leaks.
 *
 * Example:
 * LaunchedEffect(Unit) {
 *     // This block runs only once when the composable is first composed.
 *     // e.g., delay(1000); doSomething()
 * }
 *
 * If you use a state variable as the key:
 * LaunchedEffect(someState) {
 *     // This block re-runs every time someState changes.
 * }
 */
@Composable
fun DeterminateProgressSample() {
    var progress by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(Unit) {
        while (progress < 1f) {
            delay(50)
            progress = (progress + 0.01f).coerceAtMost(1f) // Ensure progress does not exceed 1
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = {progress})
        Spacer(modifier = Modifier.height(32.dp))
        LinearProgressIndicator(progress = {progress})
    }
}


@Preview(showSystemUi = true)
@Composable
fun ProgressIndicatorPreview() {
    DeterminateProgressSample()
}
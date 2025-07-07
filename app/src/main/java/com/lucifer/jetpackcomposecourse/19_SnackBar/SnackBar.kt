package com.lucifer.jetpackcomposecourse.`19_SnackBar`

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

/**
 * SnackbarHost:
 * - A composable that displays Snackbars on the screen.
 * - It listens to a SnackbarHostState and shows Snackbars as requested.
 * - Typically used inside a Scaffold to provide transient feedback to users.
 */

/*
 * SnackbarHostState:
 * - A state holder that manages the queue and display of Snackbars.
 * - Provides the showSnackbar() suspend function to enqueue a Snackbar with a message and optional action.
 * - Used by SnackbarHost to know when and what to display.
 */

/*
 * Result from snackBarHostState.showSnackbar:
 * - The showSnackbar() function returns a SnackbarResult.
 * - SnackbarResult can be:
 *   - ActionPerformed: The user clicked the action button (e.g., "Settings").
 *   - Dismissed: The Snackbar was dismissed without the action being performed.
 * - You can use this result to trigger further actions, such as opening device settings.
 */
@Composable
fun SnackBarSample() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) { padding ->

        Box(modifier = Modifier.fillMaxSize().padding(padding),
            contentAlignment = Alignment.Center) {
            Button(
                onClick = {
                    scope.launch {

                        val result = snackBarHostState.showSnackbar(
                            message = "No Internet Connection",
                            actionLabel = "Settings"
                        )

                        if(result== SnackbarResult.ActionPerformed) {
                            val intent = Intent(Settings.ACTION_SETTINGS)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            context.startActivity(intent)
                        }

                    }
                }
            ) {
                Text("Show Snackbar")
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun SnackBarPreview() {
    SnackBarSample()
}
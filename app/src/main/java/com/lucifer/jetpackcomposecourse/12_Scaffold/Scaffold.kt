package com.lucifer.jetpackcomposecourse.`12_Scaffold`

import android.graphics.Paint.Align
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

/**
 * Scaffold is a composable layout provided by Jetpack Compose.
 * It implements the basic Material Design layout structure.
 *
 * Scaffold helps arrange common UI elements such as:
 * - Top app bar
 * - Bottom navigation bar
 * - Floating action button (FAB)
 * - Drawer (navigation drawer)
 * - Main content area
 *
 * It automatically handles padding and insets for these components,
 * making it easier to build consistent and responsive layouts.
 */

/**
 * TopAppBarColors parameters:
 * - containerColor: The background color of the TopAppBar.
 * - titleContentColor: The color used for the title text.
 * - scrolledContainerColor: The background color when the TopAppBar is scrolled.
 * - navigationIconContentColor: The color for the navigation icon (e.g., back arrow or menu).
 * - actionIconContentColor: The color for action icons (e.g., search, more options).
 *
 * These colors allow you to customize the appearance of the TopAppBar for different states and content,
 * ensuring consistency with your app's theme and improving visual hierarchy.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldSample() {

    var count by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.surfaceContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.primaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.surface,
                ),
                title = {
                    Text(
                        "Top App Bar",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
            )
        },

        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    "Bottom App Bar",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },

        floatingActionButton = {
            FloatingActionButton(onClick = {
                count++
            }, shape = CircleShape) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null
                )
            }
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("FAB has been clicked $count times", fontSize = 24.sp)
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun ScaffoldPreview() {
    ScaffoldSample()
}
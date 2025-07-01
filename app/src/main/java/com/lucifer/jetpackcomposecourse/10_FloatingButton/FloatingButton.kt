package com.lucifer.jetpackcomposecourse.`10_FloatingButton`

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.lucifer.jetpackcomposecourse.R

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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SimpleFloatingActionButton() {
    val context = LocalContext.current
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "Floating Action Button Clicked", Toast.LENGTH_SHORT).show()
                          },
                shape = CircleShape // to make the FAB circular
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null
                )
            }
        },
        content = {}
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ExtendedFloatingActionButtonSample() {
    val context = LocalContext.current
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    Toast.makeText(context, "Extended FAB Clicked", Toast.LENGTH_SHORT).show()
                },
                icon = { Icon(Icons.Filled.Add, contentDescription = null) },
                text = { Text("Add") }
            )
        },
        content = {}
    )
}

@Preview(showSystemUi = true)
@Composable
fun FloatingButtonPreview() {
    ExtendedFloatingActionButtonSample()
}
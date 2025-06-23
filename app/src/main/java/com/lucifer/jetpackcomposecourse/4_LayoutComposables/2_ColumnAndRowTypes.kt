package com.lucifer.jetpackcomposecourse.`4_LayoutComposables`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * **LazyColumn**:
 * - A Jetpack Compose layout used to display a vertically scrollable list of items.
 * - Efficiently renders only the visible items, improving performance for large lists.
 * - Automatically handles scrolling and recycling of items.
 * - Items are defined using the `items` function or other DSL methods.
 * - Commonly used for lists, feeds, or any vertically scrollable content.
 */
@Composable
fun LazyColumnSample() {
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)
            .background(Color.Yellow)
    ) {

        LazyColumn {
            items(count = 100) { index ->
                Box(modifier = Modifier.padding(4.dp)
                    .background(Color.Green)) {
                    Text(
                        text = "Item $index in LazyColumn",
                        modifier = Modifier.fillMaxWidth()
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}

/**
 * **LazyRow**:
 * - A Jetpack Compose layout used to display a horizontally scrollable list of items.
 * - Efficiently renders only the visible items, improving performance for large lists.
 * - Automatically handles scrolling and recycling of items.
 * - Items are defined using the `items` function or other DSL methods.
 * - Commonly used for carousels, horizontal lists, or any horizontally scrollable content.
 */
@Composable
fun LazyRowSample() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {

        LazyRow {
            items(count = 100) { index ->
                Box(modifier = Modifier.size(100.dp)
                    .padding(4.dp)
                    .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Item $index in LazyColumn"
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ColumnsAndRowTypesPreview() {
    LazyRowSample()
}
package com.lucifer.jetpackcomposecourse.`15_PullToRefresh`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * PullToRefreshBox is a composable that provides pull-to-refresh functionality.
 *
 * Essential parameters:
 * - isRefreshing: Boolean
 *     Indicates whether the refresh indicator should be shown (true when refreshing).
 *
 * - onRefresh: () -> Unit
 *     Lambda function called when the user triggers a pull-to-refresh gesture.
 *     Typically used to update data and set isRefreshing accordingly.
 *
 * Content lambda:
 *     The composable content to display inside the PullToRefreshBox.
 *     This is usually a scrollable component like LazyColumn.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshSample() {
    var isRefreshing by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    var items by remember {
        mutableStateOf(List(10) { "Item $it" })
    }

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = {
            scope.launch {
                isRefreshing = true
                delay(2000) // Simulate network request
                items = items.shuffled()
                isRefreshing = false
            }
        },
    ) {
        LazyColumn {
            items(items.size) { i ->
                // Render Items
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = items[i])
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PullToRefreshPreview() {
    PullToRefreshSample()
}
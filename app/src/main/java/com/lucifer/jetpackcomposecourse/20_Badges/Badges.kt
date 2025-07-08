package com.lucifer.jetpackcomposecourse.`20_Badges`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * BadgedBox:
 * - A composable that allows you to display a badge (such as a notification count) over another composable, typically an icon.
 * - The `badge` parameter defines the badge content, which is usually a Badge composable.
 * - The main content (e.g., an Icon) is placed inside the BadgedBox block.
 * - Useful for showing status indicators or counts on top of icons (like a shopping cart).
 */

/**
 * Badge:
 * - A small, circular indicator used to display a short piece of information, such as a number or a dot.
 * - Can be customized with colors and content.
 * - Typically used inside the `badge` slot of a BadgedBox to show counts or notifications.
 */
@Composable
fun BadgeSample() {
    var itemCount by remember { mutableIntStateOf(1) }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BadgedBox(
                badge = {
                    if(itemCount>0) {
                        Badge(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        ) {
                            Text("$itemCount")
                        }
                    }
                }
            ) {
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = null)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    itemCount++
                }
            ) {
                Text("Add Item")
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun BadgePreview() {
    BadgeSample()
}
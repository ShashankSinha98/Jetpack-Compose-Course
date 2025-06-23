package com.lucifer.jetpackcomposecourse.`5_BottomSheet`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

/**
 * Bottom Sheet in Jetpack Compose:
 * - A Bottom Sheet is a UI component that slides up from the bottom of the screen to display additional content.
 * - In Compose, you can implement it using `ModalBottomSheet`, `BottomSheetScaffold`, or custom Composables.
 * - Common use cases: showing menus, actions, or extra information without navigating away.
 *
 * Necessary overrides and considerations:
 * - Manage the sheet's state using `ModalBottomSheetState` or `BottomSheetScaffoldState`.
 * - Handle user interactions (e.g., dismiss, expand, collapse) via state and coroutine scope.
 * - Override or provide content for the sheet and the main screen.
 * - Optionally, override back press or tap outside to dismiss behavior.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetSample() {
    // This variable controls the visibility of the bottom sheet.
    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    // This state object is used to manage the bottom sheet's state.
    var sheetState = rememberModalBottomSheetState( // initializes the state object that controls the bottom sheet's behavior (expanded, collapsed, hidden).
        skipPartiallyExpanded = false // means the bottom sheet can enter a partially expanded state (if supported).
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    showBottomSheet = true
                }
            ) {
                Text(text = "Show Bottom Sheet", color = Color.White)
            }

            if(showBottomSheet) {
                ModalBottomSheet(
                    modifier = Modifier.fillMaxHeight(),
                    sheetState = sheetState,
                    onDismissRequest = {
                        showBottomSheet = false // Dismiss the bottom sheet when the user taps outside or presses back
                    }
                ) {
                    Text(text = "This is a Bottom Sheet", fontSize = 32.sp)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BottomSheetPreview() {
    BottomSheetSample()
}
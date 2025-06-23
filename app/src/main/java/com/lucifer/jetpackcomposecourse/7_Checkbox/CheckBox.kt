package com.lucifer.jetpackcomposecourse.`7_Checkbox`

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview

/**
 * Checkbox in Jetpack Compose:
 * - Checkbox is a Material Design component used for binary selection (checked/unchecked).
 * - Commonly used in forms, lists, and settings to allow users to select one or more options.
 * - Supports customization for colors, size, and interaction states.
 */
@Composable
fun CheckboxSample() {
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )  {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Text(text = if (isChecked) "Checked" else "Unchecked")
    }
}

/**
 * Demonstrates the usage of TriStateCheckbox in Jetpack Compose.
 * - Cycles through three states: Off, On, and Indeterminate on each click. (ToggleableState.Off, ToggleableState.On, ToggleableState.Indeterminate)
 * - Displays the current state as text below the checkbox.
 * - Useful for scenarios where a checkbox can have a mixed/partial selection state.
 */
@Composable
fun TriStateCheckboxSample() {
    var checkboxState by remember { mutableStateOf(ToggleableState.Indeterminate) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TriStateCheckbox(
            state = checkboxState,
            onClick = {
                checkboxState = when (checkboxState) {
                    ToggleableState.Off -> ToggleableState.On
                    ToggleableState.On -> ToggleableState.Indeterminate
                    ToggleableState.Indeterminate -> ToggleableState.Off
                }
            }
        )
        Text("Current state: $checkboxState")
    }
}

@Composable
fun ComplexCheckboxSample() {

    var parCheckboxState by remember {
        mutableStateOf(ToggleableState.Off)
    }

    val childCheckboxState = remember {
        mutableStateListOf(false, false)
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Select All")
            TriStateCheckbox(
                state = parCheckboxState,
                onClick = {
                    parCheckboxState = when (parCheckboxState) {
                        ToggleableState.Off -> ToggleableState.On
                        ToggleableState.On -> ToggleableState.Off
                        ToggleableState.Indeterminate -> ToggleableState.Off
                    }

                    if( parCheckboxState == ToggleableState.On) {
                        childCheckboxState.replaceAll { true } // Set all child checkboxes to true
                    } else {
                        childCheckboxState.replaceAll { false } // Set all child checkboxes to false
                    }
                }
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Option 1")
            Checkbox(
                checked = childCheckboxState[0],
                onCheckedChange = { isChecked ->
                    childCheckboxState[0] = isChecked

                    if( childCheckboxState.all { it } ) { // If all child checkboxes are checked
                        parCheckboxState = ToggleableState.On
                    } else if (childCheckboxState.any { it }) { // If any child checkbox is checked
                        parCheckboxState = ToggleableState.Indeterminate
                    } else { // If no child checkboxes are checked
                        parCheckboxState = ToggleableState.Off
                    }
                }
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Option 2")
            Checkbox(
                checked = childCheckboxState[1],
                onCheckedChange = { isChecked ->
                    childCheckboxState[1] = isChecked

                    if( childCheckboxState.all { it } ) { // If all child checkboxes are checked
                        parCheckboxState = ToggleableState.On
                    } else if (childCheckboxState.any { it }) { // If any child checkbox is checked
                        parCheckboxState = ToggleableState.Indeterminate
                    } else { // If no child checkboxes are checked
                        parCheckboxState = ToggleableState.Off
                    }
                }
            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun CheckboxPreview() {
    ComplexCheckboxSample()
}
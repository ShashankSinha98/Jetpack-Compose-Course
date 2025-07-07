package com.lucifer.jetpackcomposecourse.`17_SegmentedButton`

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

/**
 * MultiChoiceSegmentedButtonRow is a Material3 composable that arranges multiple
 * SegmentedButton components in a horizontal row, allowing for multiple selections.
 * Each SegmentedButton can be toggled independently.
 *
 * Parameters used in this context:
 * - shape: Defines the shape of each segmented button, typically set using
 *   SegmentedButtonDefaults.itemShape() to ensure proper rounded corners for the
 *   first and last items.
 * - checked: Boolean value indicating whether the button is currently selected.
 * - onCheckedChange: Lambda function called when the button's checked state changes.
 *   Used here to toggle the selection and show a Toast message.
 * - label: Composable to display the label or icon for the button. In this example,
 *   it shows a different icon for each transport option.
 */
@Composable
fun SegmentedButtonSample() {
    val context = LocalContext.current
    val selectedOptions = remember {
        mutableStateListOf(false, false, false)
    }
    val options = listOf("Walk", "Ride", "Drive")

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        MultiChoiceSegmentedButtonRow {
            options.forEachIndexed { idx, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = idx,
                        count = options.size
                    ),
                    checked = selectedOptions[idx],
                    onCheckedChange = {
                        selectedOptions[idx] = !selectedOptions[idx]
                        val title = if (selectedOptions[idx]) "Selected" else "Deselected"
                        Toast.makeText(context, "$title: $label", Toast.LENGTH_SHORT).show()
                    },
                    label = {
                        when(label) {
                            "Walk" -> Icon(Icons.AutoMirrored.Filled.DirectionsWalk, contentDescription = "Walk Icon")
                            "Ride" -> Icon(Icons.Default.DirectionsBus, contentDescription = "Ride Icon")
                            "Drive" -> Icon(Icons.Default.DirectionsCar, contentDescription = "Drive Icon")
                        }
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SegmentedButtonPreview() {
    SegmentedButtonSample()
}
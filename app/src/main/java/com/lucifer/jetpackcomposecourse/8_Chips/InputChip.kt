package com.lucifer.jetpackcomposecourse.`8_Chips`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * InputChip is a Material Design component in Jetpack Compose.
 * - Used for user input, selection, or filtering.
 * - Displays a label, optional icon, and optional close/remove action.
 * - Supports click and selection states.
 * - Commonly used for tags, filters, or user choices.
 */
@Composable
fun InputChipSample() {
    var enable by remember {
        mutableStateOf(true)
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        InputChip(
            onClick = {
                enable = !enable
            },
            label = {
                val labelText = if (enable) "Enabled" else "Disabled"
                Text(labelText)
            },
            selected = enable,
            avatar = { // icon at the start of the chip
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null,
                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                )
            },
            trailingIcon = { // icon at the end of the chip
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = null,
                    modifier = Modifier.size(InputChipDefaults.AvatarSize)
                )
            }
        )
        }
}

@Preview(showSystemUi = true)
@Composable
fun InputChipPreview() {
    InputChipSample()
}
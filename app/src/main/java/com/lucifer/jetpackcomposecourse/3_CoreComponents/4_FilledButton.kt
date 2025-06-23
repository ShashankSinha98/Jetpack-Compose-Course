package com.lucifer.jetpackcomposecourse.`3_CoreComponents`

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

/**
* **Button**: (for Filled Button)
* - A composable used to create a button with a filled appearance.
* - Ideal for primary actions that require the most emphasis.
* - Commonly used for actions like submitting forms, saving data, or confirming choices.
* - Provides a visually prominent design to draw user attention.
* - Can be customized with text, icons, or other composables inside the button.
* E.g.- Submit, Save, Confirm, etc.
*/
@Composable
fun FilledButtonSample() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Filled Button")
        }
    }
}

/**
* **Tonal Button**:
* - A composable used to create a button with a tonal appearance.
* - Provides a less prominent alternative to a filled button while maintaining emphasis.
* - Suitable for secondary actions that complement primary actions.
* - Can be customized with text, icons, or other composables inside the button.
* E.g. - Add to Wishlist, Reset to Defaults, Preview Changes, etc.
*/
@Composable
fun FilledTonalButtonSample() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        FilledTonalButton (
            onClick = {
                Toast.makeText(context, "Tonal Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Filled Tonal Button")
        }
    }
}

/**
* **Outlined Button**:
* - A composable used to create a button with an outlined appearance.
* - Ideal for secondary actions that require less emphasis compared to filled buttons.
* - Commonly used for actions like "Cancel", "Learn More", or "Skip".
* - Provides a subtle design with a border around the button, making it visually distinct.
* - Can be customized with text, icons, or other composables inside the button.
* E.g.- Cancel, Skip, Learn More, etc.
*/
@Composable
fun OutlinedButtonSample() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        OutlinedButton (
            onClick = {
                Toast.makeText(context, "Outlined Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Outlined Button")
        }
    }
}

/**
* **Elevated Button**:
* - A composable used to create a button with an elevated appearance.
* - Provides a subtle shadow effect to distinguish it from the background.
* - Suitable for actions that require moderate emphasis without being overly prominent.
* - Commonly used for actions like "Share", "Explore", or "View Details".
* - Can be customized with text, icons, or other composables inside the button.
* E.g.- Share, Explore, View Details, etc.
*/
@Composable
fun ElevatedButtonSample() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ElevatedButton (
            onClick = {
                Toast.makeText(context, "Elevated Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Elevated Button")
        }
    }
}

/**
* **Text Button**:
* - A composable used to create a button with a text-only appearance.
* - Ideal for low-emphasis actions that do not require visual prominence.
* - Commonly used for actions like "Cancel", "Skip", or "Learn More".
* - Provides a minimal design without a background or border.
* - Can be customized with text, icons, or other composables inside the button.
* E.g.- Cancel, Skip, Learn More, etc.
*/
@Composable
fun TextButtonSample() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TextButton  (
            onClick = {
                Toast.makeText(context, "Text Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("Text Button")
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun FilledButtonPreview() {
    TextButtonSample()
}
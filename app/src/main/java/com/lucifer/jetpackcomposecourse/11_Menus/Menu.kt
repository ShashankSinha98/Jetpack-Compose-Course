package com.lucifer.jetpackcomposecourse.`11_Menus`

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

@Composable
fun DropDownMenuSample() {
    val context = LocalContext.current
    var expanded by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        IconButton(
            onClick = {
                expanded = !expanded
            },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(Icons.Default.MoreVert, contentDescription = null)
        }

        DropdownMenu(
            expanded= expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(x = (-20).dp, y = 0.dp) // To align the menu with the icon
        ) {

            DropdownMenuItem(
                text = { Text("Profile") },
                trailingIcon = { Icon(Icons.Outlined.Person, contentDescription = null) },
                onClick = {
                    // Handle profile click
                    expanded = false // Close the menu after selection
                    Toast.makeText(context, "Profile clicked", Toast.LENGTH_SHORT).show()
                }
            )

            HorizontalDivider()

            DropdownMenuItem(
                text = { Text("Setting") },
                trailingIcon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                onClick = {
                    // Handle Settings click
                    expanded = false // Close the menu after selection
                    Toast.makeText(context, "Setting clicked", Toast.LENGTH_SHORT).show()
                }
            )

            HorizontalDivider()

            DropdownMenuItem(
                text = { Text("About") },
                trailingIcon = { Icon(Icons.Outlined.AccountBox, contentDescription = null) },
                onClick = {
                    // Handle About click
                    expanded = false // Close the menu after selection
                    Toast.makeText(context, "About clicked", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MenuPreview() {
    DropDownMenuSample()
}
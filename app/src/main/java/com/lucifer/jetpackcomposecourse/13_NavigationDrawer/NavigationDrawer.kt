package com.lucifer.jetpackcomposecourse.`13_NavigationDrawer`

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 rememberDrawerState- Creates and remembers the state of the navigation drawer (open or closed) for use in Compose UI.

 rememberCoroutineScope - Creates and remembers a CoroutineScope tied to this composable's lifecycle.
 Use it to launch coroutines that are automatically cancelled when the composable leaves the composition.

 drawerState.open() is a suspend function because opening the drawer involves an animation, which takes time to
 complete. Suspending allows the coroutine to wait for the animation to finish without blocking the main thread,
 ensuring smooth UI updates and responsiveness.

 NavigationDrawerItem represents a single clickable item in the navigation drawer.
 - label: The text label shown for the item.
 - selected: Whether this item is currently selected (highlighted).
 - onClick: Action to perform when the item is clicked.
 - icon: Optional icon to display alongside the label.
 - modifier: Additional styling or layout options.
 * */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedDrawerSample() {

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(250.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = {
                        scope.launch { drawerState.close() }
                    }) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }
                // Inside ModalDrawerSheet
                NavigationDrawerItem(
                    label = { Text("Drawer Item 1") },
                    selected = false, // Set to true if this item is selected
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            Toast.makeText(context, "Drawer Item 1 Clicked", Toast.LENGTH_SHORT).show()
                        }
                    },
                    icon = { Icon(Icons.Default.Home, contentDescription = null) }, // Optional icon
                    modifier = Modifier.padding(8.dp)
                )

                HorizontalDivider()

                Text("Drawer Item 2", modifier = Modifier.padding(16.dp).clickable {
                    scope.launch {
                        drawerState.close()
                        Toast.makeText(context, "Drawer Item 2 Clicked", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Navigation Drawer Sample") },
                    navigationIcon = { // IconButton to open the drawer
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) { innerPadding ->
            Text(
                "Main Content",
                modifier = Modifier.padding(innerPadding).padding(16.dp)
            )
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun NavigationDrawerPreview() {
    DetailedDrawerSample()
}
package com.lucifer.jetpackcomposecourse.`0_PhillipLackner`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
* **State**:
* - Represents data that can change over time in a composable.
* - When the state changes, the composable is automatically updated to reflect the new data.
* - Example: A counter value or a list of items.

* **Recomposition**:
* - The process where Jetpack Compose redraws a composable to reflect updated state.
* - Happens automatically when the state used in the composable changes.
* - Ensures the UI stays in sync with the current state.
* - Only affected parts of the UI are redrawn, making it efficient.
*/

/**
* `remember` in Jetpack Compose stores state across recompositions.
* It keeps the value as long as the composable remains in the composition.
* Ideal for lightweight state that doesn't need to persist through configuration changes.
* Recalculates only when its inputs change.
* Example: Managing a counter or a mutable state object.
*/
@Composable
fun Counter(start: Int = 0) {
    var count by remember {
        mutableIntStateOf(start)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = count.toString(),
            fontSize = 30.sp
        )
        Button(
            onClick = {
                count+=1
            }
        ) {
            Text(text = "Click Me")
        }
    }
}

/**
* **rememberSavable**:
* - A Jetpack Compose function used to store state across recompositions and configuration changes.
* - Ideal for state that needs to persist through events like screen rotations.
* - Automatically saves and restores the state using the `SavedStateRegistry`.
* - Works with types that can be serialized or converted to a `Bundle`.
 */

/**
* **LazyColumn**:
* - A Jetpack Compose layout used to display a vertically scrollable list of items.
* - Efficiently renders only the visible items, improving performance for large lists.
* - Automatically handles scrolling and recycling of items.
* - Items are defined using the `items` function or other DSL methods.
* - Commonly used for lists, feeds, or any vertically scrollable content.
 */

/**
* **Column**:
* - A Jetpack Compose layout used to arrange child composables vertically.
* - Displays all child composables at once, without scrolling.
* - Suitable for small, static layouts where the number of items is fixed.
* - Does not optimize rendering for large datasets, as all items are rendered regardless of visibility.
* - Commonly used for simple UI structures like forms or grouped content.
 */

/**
* **Difference Between Column and LazyColumn**:
* - **Column**:
*   - Renders all child composables at once.
*   - Does not support scrolling by default. Can be made scrollable with a `Modifier.verticalScroll()`.
*   - Ideal for small, fixed layouts.
 *
* - **LazyColumn**:
*   - Optimized for large, scrollable lists.
*   - Renders only visible items, improving performance for large datasets.
*   - Automatically handles scrolling and recycling of items.
*   - Ideal for dynamic or large lists where the number of items is unknown or can grow.
*/
@Composable
fun NameList() {
    var name by remember {
        mutableStateOf("")
    }
    var names by rememberSaveable {
        mutableStateOf(listOf<String>())
    }
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp)) // add some space at the top
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { text ->
                    name = text
                },
                modifier = Modifier.weight(1f) // fill the available space, btn will take the space it needs

            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if(name.isNotBlank()) {
                        names = names + name
                        name = ""
                    }
                }
            ) {
                Text(text = "Add")
            }
        }

        LazyColumn {
            items(names) { currName ->
                Text(text = currName,
                    fontSize = 40.sp,
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 16.dp)
                )

                HorizontalDivider() // divider between items
            }
        }
    }
}

package com.lucifer.jetpackcomposecourse.`4_LayoutComposables`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


/**
 * **Column**:
 * - A Jetpack Compose layout used to arrange child composables vertically.
 * - Displays all child composables at once, without scrolling.
 * - Suitable for small, static layouts where the number of items is fixed.
 * - Does not optimize rendering for large datasets, as all items are rendered regardless of visibility.
 * - Commonly used for simple UI structures like forms or grouped content.
 *
 * Column: Equivalent to LinearLayout with android:orientation="vertical".
 */
@Composable
fun ColumnSample() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp) // order in modifier matters
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("How")
        Text("are")
        Text("you")
    }
}

/**
 * Row is a layout composable in Jetpack Compose that arranges its children horizontally.
 *
 * - It places each child side by side, starting from the left.
 * - You can customize the alignment, spacing, and size of the children within the row.
 * - Useful for creating horizontal lists or grouping UI elements in a single row.
 * - Does not support scrolling by default but can be made scrollable with a `Modifier.horizontalScroll`.
 *
 * Example use case: Displaying a row of buttons or icons in a horizontal arrangement.
 * Row: Equivalent to LinearLayout with android:orientation="horizontal".
 */
@Composable
fun RowSample() {
    Row(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp) // order in modifier matters
            .background(Color.Red),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("How")
        Text("are")
        Text("you")
    }
}

/**
 * **Box**:
 * - A layout composable in Jetpack Compose that allows stacking child composables on top of each other.
 * - Children are placed in the order they are declared, with the first child at the bottom and subsequent children layered on top.
 * - Useful for creating overlays, backgrounds, or combining multiple UI elements in a single space.
 * - You can customize alignment and positioning of children within the Box using `Modifier` and alignment properties.

 * Example use case: Displaying an image with text overlay or creating a custom button with layered elements.

 * **Equivalent in XML**:
 * - Box is equivalent to `FrameLayout` in XML layouts.
 */
@Composable
fun BoxSample() {
    Box(
        modifier = Modifier.size(200.dp)
            .background(Color.Red),
        contentAlignment = Alignment.Center,
    ) {

        Text("How", modifier = Modifier.align(Alignment.TopCenter).padding(top = 8.dp))

        Box(modifier = Modifier.size(100.dp)
            .background(Color.Green),
            contentAlignment = Alignment.Center) {
            Text("are", modifier = Modifier.align(Alignment.TopCenter).padding(top = 6.dp))

            Box(modifier = Modifier.size(50.dp)
                .background(Color.Yellow),
                contentAlignment = Alignment.Center) {
                Text("you", modifier = Modifier.align(Alignment.TopCenter).padding(top = 4.dp))
            }
        }
    }
}

/**
 * **ConstraintLayout**:
 * - A layout composable in Jetpack Compose that allows you to position and size UI elements relative to each other or the parent container.
 * - Provides flexibility for creating complex layouts with precise control over the relationships between elements.
 * - Similar to `ConstraintLayout` in XML-based layouts.

 * **Key Features**:
 * - **createRefs()**: Used to create references for child composables.
 * - **constrainAs()**: Defines constraints for each composable relative to other references or the parent.
 * - **Constraints**: Includes `top.linkTo`, `start.linkTo`, `end.linkTo`, and `bottom.linkTo` for positioning elements.

 * **Example Use Case**:
 * - Aligning multiple elements dynamically based on their relationships, such as creating a form or a dashboard layout.
 */
@Composable
fun ConstraintLayoutSample() {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
            .height(150.dp)
            .background(Color.Yellow
            )
    ) {

        // these are references to the Text composables (consider as ids in XML)
        val (text1, text2, text3) = createRefs() // Destructuring declarations, similar to python tuple unpacking
        Text(
            text = "Bottom Left",
            modifier = Modifier.constrainAs(text1) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            }.padding(8.dp),
            color = Color.Red
        )

        Text(
            text = "Center",
            modifier = Modifier.constrainAs(text2) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }.padding(8.dp),
            color = Color.Blue
        )

        Text(
            text = "Top Right",
            modifier = Modifier.constrainAs(text3) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }.padding(8.dp),
            color = Color.Green
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LayoutComposablePreview() {
    ConstraintLayoutSample()
}
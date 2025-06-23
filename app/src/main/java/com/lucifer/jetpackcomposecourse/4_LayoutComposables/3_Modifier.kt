package com.lucifer.jetpackcomposecourse.`4_LayoutComposables`

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * **Modifier**:
 * - A core concept in Jetpack Compose used to decorate or adjust composables.
 * - Modifiers can change layout, appearance, behavior, or add interaction (e.g., padding, background, click).
 * - They are applied in a chainable manner, allowing multiple modifications in sequence.
 * - Common examples: `padding()`, `fillMaxWidth()`, `background()`, `clickable()`.
 * - The order of modifiers matters and can affect the final result.
 */
@Composable
fun ModifierSample() {
    ConstraintLayout (
        modifier = Modifier.fillMaxSize()
            .background(Color.Blue)
    ) {
        val (box1, box2, box3) = createRefs()
        Box(
            modifier = Modifier.size(100.dp)
                .background(Color.Yellow)
                .constrainAs(box1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start, margin = 8.dp)
                    bottom.linkTo(parent.bottom)
                }
        )

        Box(
            modifier = Modifier.size(100.dp)
                .background(Color.Red)
                .constrainAs(box2) {
                    start.linkTo(box1.end, margin = 8.dp)
                    bottom.linkTo(box1.top)
                }
        )


        Box(
            modifier = Modifier.size(100.dp)
                .background(Color.Green)
                .constrainAs(box3) {
                    start.linkTo(box2.end, margin = 8.dp)
                    bottom.linkTo(box2.top)
                }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ModifierPreview() {
    ModifierSample()
}
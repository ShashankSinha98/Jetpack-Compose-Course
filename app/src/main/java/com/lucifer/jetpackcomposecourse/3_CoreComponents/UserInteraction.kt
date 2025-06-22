package com.lucifer.jetpackcomposecourse.`3_CoreComponents`

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview

/**
 * `SelectionContainer`:
 * - A composable that enables text selection within its scope.
 * - Any text inside this container can be selected by the user.
 * - Useful for allowing users to copy or interact with specific text content.
 * - Wrap this container around text or other composables to make them selectable.
 *
 * Example Usage:
 * SelectionContainer {
 *     Text("This text is selectable.")
 * }
 */

/**
 * `DisableSelection`:
 * - A composable that disables text selection within its scope.
 * - Any text inside this container cannot be selected, even if it is inside a `SelectionContainer`.
 * - Useful for preventing selection of specific text or content.
 * - Wrap this container around text or other composables to make them non-selectable.
 *
 * Example Usage:
 * DisableSelection {
 *     Text("This text is not selectable.")
 * }
 */
@Composable
fun PartiallySelectableText() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        SelectionContainer {

            Column {
                Text("This is a selectable text. You can select this part.")
                Text("You can also select this part, but not the next one.")

                DisableSelection {
                    Text("This part is not selectable. It is disabled for selection.")
                }

                Text("You can select this part again. Selection is enabled here.")
            }
        }
    }
}

/**
 * `pushStringAnnotation(tag, annotation)`:
 * - Used to add metadata (annotations) to specific parts of a text in Jetpack Compose.
 * - These annotations can store additional information, such as URLs, tags, or any other string data.
 * - The metadata can later be retrieved and used for actions like handling clicks, displaying tooltips, or other interactions.
 * - Each annotation has:
 *   - **Tag**: An identifier for the annotation (e.g., `"URL"`).
 *   - **Annotation**: The value associated with the tag (e.g., `"https://developer.android.com"`).
 * - You must call `pop()` to end the annotation scope; otherwise, the annotation will apply to the rest of the text.
 */

/**
 * `pop()`:
 * - Marks the end of an annotation scope that was started with `pushStringAnnotation`.
 * - Ensures that the annotation applies only to the intended text segment.
 * - Without calling `pop()`, the annotation would incorrectly apply to the rest of the text, leading to unintended behavior.
 * - It is essential to use `pop()` after adding annotations to avoid scope-related issues.
 * - Commonly used in conjunction with `pushStringAnnotation` to define the boundaries of an annotation.
 */

/**
 * `getStringAnnotations(tag, start, end)`:
 * - Retrieves annotations from an `AnnotatedString` within a specified range of text.
 * - Allows access to metadata (annotations) added to specific parts of the text, such as URLs, tags, or other string data.
 * - Returns a list of `AnnotatedString.Range` objects, where each object contains:
 *   - **Item**: The annotation value (e.g., a URL or tag).
 *   - **Start** and **End**: The range of text the annotation applies to.
 *   - **Tag**: The tag associated with the annotation.
 * - Useful for handling actions like clickable links, tooltips, or other interactions based on annotated text.
 * - The `start` and `end` parameters define the range of text to search for annotations.
 * - If no annotations are found within the specified range, an empty list is returned.
 */

/**
 * `LocalContext.current` provides access to the current Android `Context`
 *  'LocalContext.current.applicationContext' returns the application context
 **/
@Composable
fun TextWithURL() {

    val context = LocalContext.current

    val annotatedText = buildAnnotatedString {
        append("Build better apps with ")
        pushStringAnnotation(
            tag = "URL",
            annotation = "https://developer.android.com/jetpack/compose"
        )
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append("Jetpack Compose")
        }
        pop() // End the annotation scope
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = annotatedText,
            modifier = Modifier.clickable {
                val annotations = annotatedText.getStringAnnotations(tag="URL", start = 0, end=annotatedText.length)
                annotations.firstOrNull()?.let { annotation ->
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                    context.startActivity(intent)
                }
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun UserInteractionPreview() {
    TextWithURL()
}
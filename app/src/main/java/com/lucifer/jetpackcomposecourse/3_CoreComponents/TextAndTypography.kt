package com.lucifer.jetpackcomposecourse.`3_CoreComponents`

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.lucifer.jetpackcomposecourse.R


@Composable
fun SimpleText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello, Jetpack Compose!",
            color = colorResource(R.color.purple_500),
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                shadow = Shadow(
                    color = colorResource(R.color.black),
                    blurRadius = 5f
                )
            )
        )
    }
}

@Composable
fun ColorfulText() {
    val rainbowColors = listOf(
        colorResource(R.color.red),
        colorResource(R.color.orange),
        colorResource(R.color.yellow),
        colorResource(R.color.green),
        colorResource(R.color.blue),
        colorResource(R.color.indigo),
        colorResource(R.color.violet)
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = buildAnnotatedString {  // for combining multiple strings
                // string 1
                append("Do not allow people to dim your shine\n")

                // string 2 - style only applied to this part
                withStyle( // this is how you apply style to a part of the text
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColors
                        )
                    )
                ) {
                    append("because they are blinded\n")
                }

                // string 3
                append("tell them to put on some sunglasses\n")
            },
            fontSize = 18.sp,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
        )
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollableText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "This is a long text that will be scrollable. " +
                    "You can add more content here to see the scrolling effect. " +
                    "Keep adding more text until it exceeds the screen size.",
            modifier = Modifier.basicMarquee(), // This modifier makes the text scrollable
            fontSize = 50.sp
        )
    }
}

@Composable
fun EllipsisText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "This is a very long text that will be truncated with an ellipsis at the end if it exceeds the available space.",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis, // This will truncate the text with an ellipsis
            fontSize = 30.sp
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun TextAndTypographyPreview() {
    EllipsisText()
}
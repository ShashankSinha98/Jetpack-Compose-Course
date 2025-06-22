package com.lucifer.jetpackcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lucifer.jetpackcomposecourse.`3_CoreComponents`.PartiallySelectableText
import com.lucifer.jetpackcomposecourse.`3_CoreComponents`.PasswordTextFieldSample
import com.lucifer.jetpackcomposecourse.`3_CoreComponents`.TextFieldAndOutlinedTextFieldSample
import com.lucifer.jetpackcomposecourse.`3_CoreComponents`.TextWithURL
import com.lucifer.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourseTheme {
                TextWithURL()
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun Preview() {
        TextWithURL()
    }
}
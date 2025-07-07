package com.lucifer.jetpackcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lucifer.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme
import com.lucifer.jetpackcomposecourse.`16_SearchBar`.SearchScreenSample
import com.lucifer.jetpackcomposecourse.`17_SegmentedButton`.SegmentedButtonSample
import com.lucifer.jetpackcomposecourse.`18_Slider`.SliderSample
import com.lucifer.jetpackcomposecourse.`19_SnackBar`.SnackBarSample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourseTheme {
                SnackBarSample()
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun Preview() {
        SnackBarSample()
    }
}
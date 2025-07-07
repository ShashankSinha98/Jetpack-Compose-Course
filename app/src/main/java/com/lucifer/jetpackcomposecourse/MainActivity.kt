package com.lucifer.jetpackcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lucifer.jetpackcomposecourse.`14_ProgressIndicator`.CircularProgressSample
import com.lucifer.jetpackcomposecourse.`14_ProgressIndicator`.DeterminateProgressSample
import com.lucifer.jetpackcomposecourse.`14_ProgressIndicator`.LinearProgressSample
import com.lucifer.jetpackcomposecourse.`15_PullToRefresh`.PullToRefreshSample
import com.lucifer.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme
import com.lucifer.jetpackcomposecourse.ui.theme.SearchScreenSample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourseTheme {
                SearchScreenSample()
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun Preview() {
        SearchScreenSample()
    }
}
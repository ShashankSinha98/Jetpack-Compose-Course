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
import com.lucifer.jetpackcomposecourse.`20_Badges`.BadgeSample
import com.lucifer.jetpackcomposecourse.`21_Switch`.SwitchSample
import com.lucifer.jetpackcomposecourse.`22_DatePicker`.DatePickerSample
import com.lucifer.jetpackcomposecourse.`23_TimePicker`.TimePickerSample
import com.lucifer.jetpackcomposecourse.`24_BottomNavigation`.BottomNavigationBarSample
import com.lucifer.jetpackcomposecourse.`25_TopAppBar`.CenterAlignedTopAppBarSample
import com.lucifer.jetpackcomposecourse.`25_TopAppBar`.TopAppBarSample
import com.lucifer.jetpackcomposecourse.`26_Navigation`.AppNavHost
import com.lucifer.jetpackcomposecourse.`27_Animation`.AnimatedBoxSample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourseTheme {
                AnimatedBoxSample()
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun Preview() {
        AnimatedBoxSample()
    }
}
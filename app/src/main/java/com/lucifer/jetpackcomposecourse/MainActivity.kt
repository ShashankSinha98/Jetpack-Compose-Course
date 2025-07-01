package com.lucifer.jetpackcomposecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lucifer.jetpackcomposecourse.`10_FloatingButton`.ExtendedFloatingActionButtonSample
import com.lucifer.jetpackcomposecourse.`10_FloatingButton`.SimpleFloatingActionButton
import com.lucifer.jetpackcomposecourse.`11_Menus`.DropDownMenuSample
import com.lucifer.jetpackcomposecourse.`12_Scaffold`.ScaffoldSample
import com.lucifer.jetpackcomposecourse.`3_CoreComponents`.FilledButtonSample
import com.lucifer.jetpackcomposecourse.`3_CoreComponents`.PartiallySelectableText
import com.lucifer.jetpackcomposecourse.`3_CoreComponents`.PasswordTextFieldSample
import com.lucifer.jetpackcomposecourse.`3_CoreComponents`.TextFieldAndOutlinedTextFieldSample
import com.lucifer.jetpackcomposecourse.`3_CoreComponents`.TextWithURL
import com.lucifer.jetpackcomposecourse.`4_LayoutComposables`.ConstraintLayoutSample
import com.lucifer.jetpackcomposecourse.`4_LayoutComposables`.LazyColumnSample
import com.lucifer.jetpackcomposecourse.`4_LayoutComposables`.LazyRowSample
import com.lucifer.jetpackcomposecourse.`5_BottomSheet`.BottomSheetSample
import com.lucifer.jetpackcomposecourse.`7_Checkbox`.CheckboxSample
import com.lucifer.jetpackcomposecourse.`7_Checkbox`.ComplexCheckboxSample
import com.lucifer.jetpackcomposecourse.`7_Checkbox`.TriStateCheckboxSample
import com.lucifer.jetpackcomposecourse.`8_Chips`.InputChipSample
import com.lucifer.jetpackcomposecourse.`9_DialogBox`.AlertDialogSample
import com.lucifer.jetpackcomposecourse.`9_DialogBox`.DialogSample
import com.lucifer.jetpackcomposecourse.`9_DialogBox`.DialogWithImageSample
import com.lucifer.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourseTheme {
                ScaffoldSample()
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun Preview() {
        ScaffoldSample()
    }
}
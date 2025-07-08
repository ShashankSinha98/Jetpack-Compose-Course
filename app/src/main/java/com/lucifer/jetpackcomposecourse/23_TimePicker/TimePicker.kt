package com.lucifer.jetpackcomposecourse.`23_TimePicker`

import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun TimePickerSample() {
    val context = LocalContext.current
    var time by remember { mutableStateOf("") }
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        TimePickerDialog(
            context,
            { _, selectedHour, selectedMinute ->
                time = String.format("%02d:%02d", selectedHour, selectedMinute)
                showDialog = false
            },
            hour,
            minute,
            true // 24 hour view
        ).show()
    }

    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center) {

        OutlinedTextField(
            value = time,
            onValueChange = {},
            label = {Text("Select Time")},
            readOnly = true,
            trailingIcon = {
                Icon(imageVector = Icons.Filled.AccessTime, contentDescription = null, modifier = Modifier.clickable {
                    showDialog = true
                })
            },
            modifier = Modifier.wrapContentWidth(),
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun TimePickerPreview() {
    TimePickerSample()
}
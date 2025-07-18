package com.lucifer.jetpackcomposecourse.`21_Switch`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SwitchSample() {

    var isChecked by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Switch(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                },
                thumbContent = if(isChecked) {
                    {
                        Icon(imageVector = Icons.Filled.Check, contentDescription = null, modifier = Modifier.size(SwitchDefaults.IconSize))
                    }
                } else {
                    null
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Switch is ${if (isChecked) "ON" else "OFF"}")
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun SwitchPreview() {
    SwitchSample()
}
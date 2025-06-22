package com.lucifer.jetpackcomposecourse.`3_CoreComponents`

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.lucifer.jetpackcomposecourse.R

/**
- 'remember' is used to store a value in memory across recompositions
- 'rememberSaveable' is used to store a value in memory across recompositions, similar to remember.
However, it also saves the state in case the process is killed or the configuration changes

- recomposition is the process of re-executing composable functions to update the UI when the state changes.
It ensures that the UI reflects the latest data or state.

- 'mutableStateOf' create a state object that can be observed for changes.
When the value of the state changes, it triggers recomposition of the composables that read the state,
ensuring the UI updates automatically.
 * */
@Composable
fun TextFieldAndOutlinedTextFieldSample() {
    var text by remember { // 'by' is used for 'delegation', allowing you to use the variable as if it were a regular variable
        mutableStateOf("")
    }

    val rainbowColors = listOf(
        colorResource(R.color.red),
        colorResource(R.color.orange),
        colorResource(R.color.yellow),
        colorResource(R.color.green),
        colorResource(R.color.blue),
        colorResource(R.color.indigo),
        colorResource(R.color.violet)
    )

    val brush = Brush.linearGradient(
        colors = rainbowColors
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        // 2 types of text fields - TextField and OutlinedTextField
        // Note: when text changes, it updates in both TextField and OutlinedTextField
        Column  {
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                placeholder = {
                    Text("Hint text")
                },
                textStyle = TextStyle(brush = brush)
            )

            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it // Update the text state when the value changes
                },
                label = {
                    Text("Enter text") // Label for the text field
                }
            )
        }
    }
}

@Composable
fun PasswordTextFieldSample() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Enter Password")
            },
            visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(), // to show and hide the password
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password // to show the password keyboard
                //  Indicates that the keyboard should be optimized for password input.
            //  This typically includes hiding predictive text and showing a keyboard layout suitable for entering passwords
            ),
            trailingIcon = {
                val icon = if(passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(
                    onClick = {
                        passwordVisible = !passwordVisible // Toggle the visibility of the password
                    }
                ) {
                    Icon(imageVector = icon, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                }
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun OutlinedTextFieldPreview() {
    PasswordTextFieldSample()
}
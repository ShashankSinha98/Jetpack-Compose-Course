package com.lucifer.jetpackcomposecourse.`0_PhillipLackner`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Counter(start: Int = 0) {
    var count by remember {
        mutableIntStateOf(start)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = count.toString(),
            fontSize = 30.sp
        )
        Button(
            onClick = {
                count+=1
            }
        ) {
            Text(text = "Click Me")
        }
    }
}

@Composable
fun NameList() {
    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp)) // add some space at the top
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { text ->
                    name = text
                },
                modifier = Modifier.weight(1f) // fill the available space, btn will take the space it needs

            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if(name.isNotBlank()) {
                        names = names + name
                        name = ""
                    }
                }
            ) {
                Text(text = "Add")
            }
        }

        LazyColumn {
            items(names) { currName ->
                Text(text = currName,
                    fontSize = 40.sp,
                    modifier = Modifier.fillMaxWidth()
                        .padding(vertical = 16.dp)
                )

                HorizontalDivider() // divider between items
            }
        }
    }
}

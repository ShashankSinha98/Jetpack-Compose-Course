package com.lucifer.jetpackcomposecourse.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon"
            )
        },
        placeholder = { Text("Search...") },
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    )
}

@Composable
fun SearchScreenSample() {
    var query by remember { mutableStateOf("") }
    val items = listOf("Apple", "Banana", "Cherry", "Date", "Elderberry",
        "Fig", "Grape", "Honeydew", "Kiwi", "Lemon", "Mango", "Nectarine",
        "Orange", "Papaya", "Quince", "Raspberry", "Strawberry", "Tangerine",
        "Ugli fruit", "Vanilla bean", "Watermelon"
    )
    val filteredItems = items.filter { it.contains(query, ignoreCase = true) }

    Column(modifier = Modifier.padding(16.dp)) {
        SearchBar(query, onQueryChange = { it ->
            query = it
        })
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(filteredItems.size) { i ->
                Text(text = filteredItems[i], modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SearchBarPreview() {
    SearchScreenSample()
}
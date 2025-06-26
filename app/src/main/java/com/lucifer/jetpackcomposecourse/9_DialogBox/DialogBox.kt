package com.lucifer.jetpackcomposecourse.`9_DialogBox`

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.lucifer.jetpackcomposecourse.R

@Composable
fun DialogSample() {
    val context = LocalContext.current
    var showDialog by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { showDialog = !showDialog }) {
            Text("Show Dialog")
        }

        if(showDialog) {
            Dialog(onDismissRequest = {showDialog=false}) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .padding(16.dp, 8.dp, 16.dp, 8.dp),
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("This is a simple Dialog", fontSize = 24.sp)

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            OutlinedButton(onClick = { showDialog = false }) {
                                Text("Cancel")
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Button(onClick = {
                                Toast.makeText(context, "Confirm clicked", Toast.LENGTH_SHORT).show()
                            }) {
                                Text("Confirm")
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun DialogWithImageSample() {
    val context = LocalContext.current
    var showDialog by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { showDialog = !showDialog }) {
            Text("Show Image Dialog")
        }

        if(showDialog) {
            Dialog(onDismissRequest = {showDialog=false}) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .padding(16.dp, 8.dp, 16.dp, 8.dp),
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            modifier = Modifier
                                .width(250.dp).height(200.dp).padding(bottom = 16.dp)
                                .background(Color.Red),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(R.drawable.sample_img), contentDescription = null)


                        Text("This is a simple Dialog", fontSize = 16.sp)

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            OutlinedButton(onClick = { showDialog = false }) {
                                Text("Cancel")
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Button(onClick = {
                                Toast.makeText(context, "Confirm clicked", Toast.LENGTH_SHORT).show()
                            }) {
                                Text("Confirm")
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun AlertDialogSample() {
    val context = LocalContext.current
    var showDialog by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { showDialog = !showDialog }) {
            Text("Show Alert Dialog")
        }

    if(showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false},
                title = { Text("Alert Dialog") },
                text = { Text("This is an Alert Dialog with a title and text content.") },
                confirmButton = {
                    Button(onClick = {
                        Toast.makeText(context, "Confirm clicked", Toast.LENGTH_SHORT).show()
                        showDialog = false
                    }) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    OutlinedButton(onClick = {showDialog=false}) {
                        Text("Dismiss")
                    }
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DialogBoxPreview() {
    AlertDialogSample()
}
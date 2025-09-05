package com.example.lecture5_in_class_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lecture5_in_class_practice.ui.theme.Lecture5inclasspracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lecture5inclasspracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConcatScreen()
                }
            }
        }
    }
}

@Composable
fun ConcatScreen() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var concatenatedResult by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("First Input") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Second Input") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            concatenatedResult = text1 + text2
        }) {
            Text("Concatenate")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Result: $concatenatedResult")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lecture5inclasspracticeTheme {
        ConcatScreen()
    }
}
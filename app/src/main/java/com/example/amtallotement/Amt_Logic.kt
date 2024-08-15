package com.example.amtallotement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Amt_Logic : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VideologicScreen()
            Amount_logic()
                }
            }
        }


@Preview(showBackground = true)
@Composable
fun Preview_Logic() {
    Amount_logic()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Amount_logic() {
    var amount by remember { mutableStateOf("") }
    var numberOfPersons by remember { mutableStateOf("") }
    var amountPerPerson by remember { mutableStateOf(0.0) }
    var showResult by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(150.dp)
                .padding(top = 40.dp) // Add padding to the top
        ) {
            Box {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.searchll),
                    contentDescription = "Card background",
                    contentScale = ContentScale.Crop
                )
                Text(
                    text ="Welcome in Amount Calculate App",
                    fontStyle = FontStyle.Italic,
                    color = Color.Blue,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(top = 26.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp), // Adjust padding as needed
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top // Align content to the top
        ) {
            TextField(
                modifier = Modifier.padding(top = 12.dp),
                value = amount,
                onValueChange = { amount = it },
                label = { Text("Enter Total Amount") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            TextField(
                modifier = Modifier.padding(top = 12.dp),
                value = numberOfPersons,
                onValueChange = { numberOfPersons = it },
                label = { Text("Enter Number of Persons") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(
                modifier = Modifier.padding(top = 18.dp),
                onClick = {
                    val totalAmount = amount.toDoubleOrNull() ?: 0.0
                    val persons = numberOfPersons.toIntOrNull() ?: 0
                    if (persons > 0) {
                        amountPerPerson = totalAmount / persons
                        showResult = true
                    }
                }
            ) {
                Text(text = "Calculate")
            }

            if (showResult) {
                Text(
                    modifier = Modifier.padding(top = 18.dp),
                    text = "Amount per person: $amountPerPerson"
                )
                val numPersons = numberOfPersons.toIntOrNull() ?: 0
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) { // Add scrollable Column
                    for (i in 1..numPersons) {
                        Text(text = "Person $i: $amountPerPerson")
                    }
                }
            }
            }
        }
    }


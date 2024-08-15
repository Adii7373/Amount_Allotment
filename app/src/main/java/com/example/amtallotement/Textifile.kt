package com.example.amtallotement

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.amtallotement.ui.theme.AmtAllotementTheme

class Textifile : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AmtAllotementTheme {
                VideooScreen()
                TextFieldExample()

            // Apply padding

            }
        }
    }
}

@Composable
fun TextFieldExample() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var emailError by remember{ mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Email TextField
        TextField(
            value = email,
            onValueChange = {
                email = it
                emailError = !isValidEmail(it) // Check email validity
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = { Text("xyz@gmail.com") },
            label = { Text("Enter Your Email Id") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            },
            isError = emailError, // Show error state
            supportingText = {
                if (emailError) {
                    Text("Invalid email format")
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField with Toggle for Visibility
        TextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = !isValidPassword(it) // Check password validity
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text("Adkd256*") },
            label = { Text("Enter Your Password") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
            },
            trailingIcon = {val image = if (passwordVisible)
                Icons.Default.Visibility
            else
                Icons.Default.VisibilityOff

                IconButton(onClick = {
                    passwordVisible = !passwordVisible
                }) {
                    Icon(imageVector = image, contentDescription = null)
                }
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            isError = passwordError, // Show error state
            supportingText = {
                if (passwordError) {
                    Text("Password must be at least 8 characters long")
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(modifier = Modifier.padding(11.dp), text = "You typed: $email")

        Text(modifier = Modifier.padding(11.dp), text = "Password visibility is  ${if (passwordVisible) "Visible" else "Hidden"}")


        val context = LocalContext.current

        Button(
            modifier = Modifier.padding(top = 40.dp),
            onClick = {
                if (!emailError && !passwordError && email.isNotBlank() && password.isNotBlank()) {
                    Toast.makeText(context, "You Successfully Filled", Toast.LENGTH_SHORT).show()
                    val intent = Intent(context, Amt_Logic::class.java)
                    context.startActivity(intent)
                } else {
                    // Show an error message or handle the empty fields case
                    Toast.makeText(context, "Please fill both email and password correctly", Toast.LENGTH_SHORT).show()
                }
            },
            enabled = !emailError && !passwordError // Disable button if there are errors
        ) {
            Text(text = "Click On Next")
        }
    }
}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isValidPassword(password: String): Boolean {
    return password.length >= 8
}

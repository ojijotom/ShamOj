package com.hasham.nyumbalink.ui.screens.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

val LuxBackground = Color(0xFF121212)
val LuxGold = Color(0xFFD4AF37)
val LuxText = Color(0xFFF5F5F5)
val LuxCard = Color(0xFF1E1E1E)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavController) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var message by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Contact Us", color = LuxGold, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = LuxGold)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = LuxBackground
                )
            )
        },
        containerColor = LuxBackground,
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(20.dp)
            ) {
                Text("We'd love to hear from you!", color = LuxGold, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)

                Spacer(modifier = Modifier.height(24.dp))

                // Contact Info
                ContactInfo(label = "Phone", value = "+254 700 123456")
                ContactInfo(label = "Email", value = "info@nyumbalink.com")
                ContactInfo(label = "Location", value = "Riverside Drive, Nairobi")

                Spacer(modifier = Modifier.height(32.dp))

                // Contact Form
                Text("Send us a message", color = LuxGold, fontSize = 18.sp, fontWeight = FontWeight.Medium)

                Spacer(modifier = Modifier.height(16.dp))

                LuxTextField("Your Name", name) { name = it }
                Spacer(modifier = Modifier.height(12.dp))

                LuxTextField("Your Email", email) { email = it }
                Spacer(modifier = Modifier.height(12.dp))

                LuxTextField("Your Message", message, singleLine = false) { message = it }
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { /* Handle submit */ },
                    colors = ButtonDefaults.buttonColors(containerColor = LuxGold),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Submit", color = LuxBackground, fontWeight = FontWeight.Bold)
                }
            }
        }
    )
}

@Composable
fun ContactInfo(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 6.dp)) {
        Text(label, color = LuxGold, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        Text(value, color = LuxText, fontSize = 16.sp)
    }
}

@Composable
fun LuxTextField(label: String, value: TextFieldValue, singleLine: Boolean = true, onValueChange: (TextFieldValue) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = LuxGold) },
        singleLine = singleLine,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = LuxGold,
            unfocusedBorderColor = Color.Gray,
            cursorColor = LuxGold,
            focusedTextColor = LuxText,
            unfocusedTextColor = LuxText
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ContactScreenPreview() {
    ContactScreen(navController = rememberNavController())
}

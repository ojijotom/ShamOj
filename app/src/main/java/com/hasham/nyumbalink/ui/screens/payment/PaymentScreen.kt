package com.hasham.nyumbalink.ui.screens.payment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.background
import com.hasham.nyumbalink.R

@Composable
fun PaymentScreen(navController: NavController) {
    val dimGold = Color(0xFFB8962E) // Dimmer gold tone
    val black = Color.Black

    var nameOnCard by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var expiry by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(black) // Solid black background
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Payment Details",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = dimGold
        )

        Spacer(modifier = Modifier.height(20.dp))

        PaymentTextField("Name on Card", nameOnCard, { nameOnCard = it }, dimGold)
        PaymentTextField("Card Number", cardNumber, { cardNumber = it }, dimGold, KeyboardType.Number)
        PaymentTextField("Expiry Date (MM/YY)", expiry, { expiry = it }, dimGold)
        PaymentTextField("CVV", cvv, { cvv = it }, dimGold, KeyboardType.Number)

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Handle payment */ },
            colors = ButtonDefaults.buttonColors(containerColor = dimGold),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Pay Now", fontWeight = FontWeight.Medium, color = Color.White)
        }
    }
}



@Composable
fun PaymentTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    borderColor: Color,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = borderColor) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedBorderColor = borderColor,
            unfocusedBorderColor = borderColor,
            cursorColor = borderColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun PaymentScreenPreview() {
    PaymentScreen(navController = rememberNavController())
}






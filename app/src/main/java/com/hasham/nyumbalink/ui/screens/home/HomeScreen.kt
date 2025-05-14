package com.hasham.nyumbalink.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hasham.nyumbalink.R

data class Property(
    val title: String,
    val location: String,
    val price: String,
    val imageRes: Int
)

@Composable
fun HomeScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }

    val properties = listOf(
        Property("Penthouse Apartment", "Westlands, Nairobi", "KES 58M", R.drawable.qsm),
        Property("Luxury Villa", "Runda", "KES 120M", R.drawable.qsm),
        Property("Executive Bungalow", "Karen", "KES 75M", R.drawable.qsm)
    )

    val backgroundColor = Color(0xFF121212)
    val gold = Color(0xFFD4AF37)
    val cardColor = Color(0xFF1E1E1E)
    val textColor = Color(0xFFF5F5F5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        // App Header
        Text(
            text = "NyumbaLink",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = gold
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search luxury homes...", color = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = gold,
                unfocusedBorderColor = Color.Gray,
                cursorColor = gold,
                focusedTextColor = textColor,
                unfocusedTextColor = textColor
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Featured Property", color = gold, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(R.drawable.qsm),
            contentDescription = "Featured",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Available Listings", color = gold, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(properties) { property ->
                LuxuriousPropertyCard(property, cardColor, textColor, gold)
                Spacer(modifier = Modifier.height(14.dp))
            }
        }
    }
}

@Composable
fun LuxuriousPropertyCard(property: Property, background: Color, textColor: Color, accent: Color) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = background),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = property.imageRes),
                contentDescription = property.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(property.title, color = textColor, fontWeight = FontWeight.Bold)
                Text(property.location, color = Color.Gray)
                Text(property.price, color = accent, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}



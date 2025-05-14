package com.hasham.nyumbalink.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hasham.nyumbalink.R
import com.hasham.nyumbalink.navigation.ROUT_CONTACT
import com.hasham.nyumbalink.navigation.ROUT_DASHBOARD
import com.hasham.nyumbalink.navigation.ROUT_HOME
import com.hasham.nyumbalink.navigation.ROUT_LOGIN
import kotlinx.coroutines.delay

// Luxurious gold tone
val Gold = Color(0xFFFFD700)


@Composable
fun SplashScreenScreen(navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    // Auto navigation after delay
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(ROUT_LOGIN)
    }

    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            NavigationBar(containerColor = Color.Black.copy(alpha = 0.8f)) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Gold) },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    },
                    label = { Text("Home", color = Gold) },
                    alwaysShowLabel = true
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "Contact", tint = Gold) },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(ROUT_CONTACT)
                    },
                    label = { Text("Contact", color = Gold) },
                    alwaysShowLabel = true
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Dashboard", tint = Gold) },
                    selected = selectedIndex == 2,
                    onClick = {
                        selectedIndex = 2
                        navController.navigate(ROUT_DASHBOARD)
                    },
                    label = { Text("Dashboard", color = Gold) },
                    alwaysShowLabel = true
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.Black)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                // Text first
                Text(
                    text = "NyumbaLink",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Gold,
                    letterSpacing = 1.5.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Luxury Homes. Modern Living.",
                    fontSize = 22.sp,
                    color = Gold.copy(alpha = 0.9f),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Image below the text
                Image(
                    painter = painterResource(id = R.drawable.qsm),
                    contentDescription = "Logo",
                    modifier = Modifier.size(200.dp)
                )

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreenScreen(rememberNavController())
}

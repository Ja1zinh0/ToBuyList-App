package com.ja1zinh0.appdecompras.ui.view.start

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.ja1zinh0.appdecompras.ui.components.GenericRoundButton
import com.ja1zinh0.appdecompras.ui.components.GoogleRoundButton

@Composable
fun StartScreen(
navController: NavController
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier.padding(top = 50.dp),
                    text = "*nome do app(sla qual)*",
                    style = TextStyle(fontSize = 35.sp, color = MaterialTheme.colorScheme.onSurface)
                )
                Icon(
                    Icons.Outlined.ShoppingCart, contentDescription = "Cart Icon",
                    modifier = Modifier
                        .width(250.dp)
                        .height(250.dp)
                        .padding(top = 20.dp),
                    tint = MaterialTheme.colorScheme.primaryContainer,
                    )
                Box(modifier = Modifier.height(80.dp)) {}
                GenericRoundButton(
                    backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                    borderColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    text = "Login",
                    textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    onClick = {navController.navigate("loginScreen")}
                )
                Box(modifier = Modifier.height(24.dp)) {}
                GenericRoundButton(
                    backgroundColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    borderColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    textColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    text = "Sign Up",
                    onClick = {navController.navigate("signupScreen")}
                )
                Text(text = "Or login using", style = TextStyle(fontSize = 16.sp))
                Box(modifier = Modifier.height(36.dp)) {}
                GoogleRoundButton(
                    backgroundColor = Color.White,
                    borderColor = Color.Black,
                    text = "Login using Google",
                    textColor = Color.Black
                )
            }
        }
    )
}
package com.ja1zinh0.appdecompras.ui.view.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ja1zinh0.appdecompras.ui.components.GenericRoundButton
import com.ja1zinh0.appdecompras.ui.components.GenericTextField
import com.ja1zinh0.appdecompras.ui.components.GoogleRoundButton

@Composable
fun SignupScreen(
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
                verticalArrangement = Arrangement.Center
            ) {
                Text("Sign Up", style = TextStyle(fontSize = 58.sp))
                Box(modifier = Modifier.padding(top = 10.dp))
                Text("Welcome to *nome do app*", style = TextStyle(fontSize = 20.sp))
                Box(modifier = Modifier.padding(top = 30.dp))
                GenericTextField(
                    "Email",
                    KeyboardType.Email,
                    hidePasswordInitially = false
                )
                Box(modifier = Modifier.padding(top = 10.dp))
                GenericTextField(
                    label = "Password",
                    keyboardType = KeyboardType.Password,
                    showTrailing = true,
                    hidePasswordInitially = true
                )
                Box(modifier = Modifier.padding(top = 10.dp))
                GenericTextField(
                    label = "Confirm Password",
                    keyboardType = KeyboardType.Password,
                    showTrailing = true,
                    hidePasswordInitially = true
                )
                Box(modifier = Modifier.padding(top = 60.dp))
                GenericRoundButton(
                    backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                    borderColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    text = "Sign Up",
                    textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    onClick = {}
                )
                Box(modifier = Modifier.height(36.dp)) {}
                GoogleRoundButton(
                    backgroundColor = Color.White,
                    borderColor = Color.Black,
                    text = "Sign Up using Google",
                    textColor = Color.Black
                )
            }
        }
    )
}
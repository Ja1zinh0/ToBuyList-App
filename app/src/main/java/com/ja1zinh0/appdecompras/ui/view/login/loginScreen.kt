package com.ja1zinh0.appdecompras.ui.view.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ja1zinh0.appdecompras.ui.components.GenericRoundButton
import com.ja1zinh0.appdecompras.ui.components.GenericTextField

@Composable
fun LoginScreen(
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
                Text("Hello!", style = TextStyle(fontSize = 68.sp))
                Text("Welcome back!", style = TextStyle(fontSize = 36.sp))
                Box(modifier = Modifier.padding(top = 10.dp))
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
                Row(
                    modifier = Modifier.fillMaxWidth(0.75F).padding(top = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(text = "Forgot password?",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.clickable {}
                    )
                }
                Box(modifier = Modifier.padding(top = 60.dp))
                GenericRoundButton(
                    backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                    borderColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    text = "Login",
                    textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    onClick = {}
                )
                Row(Modifier.padding(top = 4.dp)) {
                    Text(
                        "Don't have an account yet?",
                        style = TextStyle(
                            fontSize = 16.sp,
                        )
                    )
                    Box(Modifier.width(5.dp))
                    Text("Sign Up",
                        style = TextStyle(
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.clickable { navController.navigate("signupScreen") }
                    )
                }
            }
        }
    )
}
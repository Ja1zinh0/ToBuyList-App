package com.ja1zinh0.appdecompras.ui.view.recoverpsswrd

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.LockOpen
import androidx.compose.material.icons.outlined.LockReset
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ja1zinh0.appdecompras.ui.components.GenericRoundButton
import com.ja1zinh0.appdecompras.ui.components.GenericTextField

@Composable
fun RecoverPsswrdScreen(navController: NavController) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    Icons.Outlined.LockReset, contentDescription = "Lock Icon",
                    modifier = Modifier
                        .width(250.dp)
                        .height(250.dp)
                        .padding(top = 40.dp),
                    tint = MaterialTheme.colorScheme.primaryContainer,
                )
                Text(
                    "Forgot password?",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                )
                Text(
                    "Enter your email below to reset your password",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                )
                Box(modifier = Modifier.height(20.dp)) {}
                GenericTextField(
                    "Email",
                    KeyboardType.Email,
                    hidePasswordInitially = false
                )
                Box(modifier = Modifier.height(80.dp)) {}
                GenericRoundButton(
                    backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                    borderColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    text = "Submit",
                    textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    onClick = {}
                )
            }
        }
    )
}
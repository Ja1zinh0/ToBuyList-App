package com.ja1zinh0.appdecompras.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Visibility
import org.w3c.dom.Text

@Composable
fun GenericTextField(
    label: String,
    keyboardType: KeyboardType,
    showTrailing: Boolean = false,
    hidePasswordInitially: Boolean = true,
) {
    var value by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(!hidePasswordInitially) }

    TextField(
        value = value,
        onValueChange = { value = it },
        singleLine = true,
        label = {
            Text(
                text = label, textAlign = TextAlign.Start,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
            )
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            focusedContainerColor = MaterialTheme.colorScheme.background,
        ),
        textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp),
        modifier = Modifier.fillMaxWidth(0.75F),
        visualTransformation = if (keyboardType == KeyboardType.Password && !isPasswordVisible) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        trailingIcon = {
            if (showTrailing && keyboardType == KeyboardType.Password) {
                IconButton(onClick = {
                    isPasswordVisible = !isPasswordVisible
                }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (isPasswordVisible) "Hide Password" else "Show Password"
                    )
                }
            }
        }
    )
}
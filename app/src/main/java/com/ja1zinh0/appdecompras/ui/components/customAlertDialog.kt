package com.ja1zinh0.appdecompras.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateCardAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (String) -> Unit,
    dialogTitle: String,
) {
    var textFieldTitle by remember { mutableStateOf("") }
    AlertDialog(
        containerColor = MaterialTheme.colorScheme.secondary,
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = dialogTitle,
                style = TextStyle(fontSize = 26.sp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSecondary
            )
        },
        text = {
            TextField(
                maxLines = 1,
                value = textFieldTitle,
                onValueChange = { textFieldTitle = it },
                colors = TextFieldDefaults.colors(
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                ),
                label = {
                    Text(
                        text = "Card title",
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
                    )
                },
                placeholder = { Text(text = "Write the card title here") },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation(textFieldTitle)
                }
            ) {
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                        .width(80.dp)
                        .height(40.dp)
                        .background(MaterialTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Yes",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                        .width(80.dp)
                        .height(40.dp)
                        .background(MaterialTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Cancel",
                        style = TextStyle(color = MaterialTheme.colorScheme.onSurface),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    )
}

@Composable
fun UpdateCardAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (String) -> Unit,
    dialogTitle: String,
) {
    var textFieldTitle by remember { mutableStateOf("") }
    AlertDialog(
        containerColor = MaterialTheme.colorScheme.secondary,
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = dialogTitle,
                style = TextStyle(fontSize = 26.sp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSecondary
            )
        },
        text = {
            TextField(
                maxLines = 1,
                value = textFieldTitle,
                onValueChange = { textFieldTitle = it },
                colors = TextFieldDefaults.colors(
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                ),
                label = {
                    Text(
                        text = "Card title",
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold),
                    )
                },
                placeholder = { Text(text = "Write a new card title here") },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation(textFieldTitle)
                }
            ) {
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                        .width(80.dp)
                        .height(40.dp)
                        .background(MaterialTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Update",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                        .width(80.dp)
                        .height(40.dp)
                        .background(MaterialTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Cancel",
                        style = TextStyle(color = MaterialTheme.colorScheme.onSurface),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    )
}

@Composable
fun DeleteCardAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (Int) -> Unit,
    cardID: Int
) {
    AlertDialog(
        containerColor = MaterialTheme.colorScheme.secondary,
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Delete Card?",
                style = TextStyle(fontSize = 26.sp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSecondary
            )
        },
        text = {
            Text(
                text = "Are you sure you want to delete this card?", style = TextStyle(
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSecondary,
                    textAlign = TextAlign.Center
                )
            )
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation(cardID)
                }
            ) {
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                        .width(80.dp)
                        .height(40.dp)
                        .background(MaterialTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Yes",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                        .width(80.dp)
                        .height(40.dp)
                        .background(MaterialTheme.colorScheme.surface),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "No",
                        style = TextStyle(color = MaterialTheme.colorScheme.onSurface),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    )
}

@Composable
fun CreateItemAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: (String, Float, Int) -> Unit,
) {
    var textFieldValue by remember { mutableStateOf("") }
    var numberFieldValue by remember { mutableStateOf("") }
    var quantityFieldValue by remember { mutableStateOf("") }

    val dialogContent = @Composable {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            OutlinedTextField(
                label = { Text("Product") },
                placeholder = { Text(text = "Write the product name") },
                value = textFieldValue,
                onValueChange = { newValue ->
                    val maxTextFieldLength = 20
                    if (newValue.length <= maxTextFieldLength) {
                        textFieldValue = newValue
                    }
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        defaultKeyboardAction(ImeAction.Done)
                    }
                )
            )
            OutlinedTextField(
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                label = { Text("Price") },
                placeholder = { Text(text = "Write the product price") },
                value = numberFieldValue,
                onValueChange = { newValue ->
                    val maxTextFieldLength = 7
                    val sanitizedValue = newValue.filter { it.isDigit() || it == ',' || it == '.' }
                        .replace(',', '.')
                    val dotCount = sanitizedValue.count { it == '.' }
                    val isFirstCharDot = sanitizedValue.startsWith('.')
                    if (newValue.length <= maxTextFieldLength && dotCount <= 1 && !isFirstCharDot) {
                        numberFieldValue = sanitizedValue
                    }
                },
                maxLines = 1,
                modifier = Modifier.padding(top = 15.dp),
            )
            OutlinedTextField(
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                label = { Text("Quantity") },
                placeholder = { Text(text = "Product quantity") },
                value = quantityFieldValue,
                onValueChange = { newValue ->
                    val maxTextFieldLength = 2
                    val sanitizedValue = newValue.filter { it.isDigit() }
                    if (sanitizedValue != "0" && newValue.length <= maxTextFieldLength) {
                        quantityFieldValue = sanitizedValue
                    }
                },
                maxLines = 1,
                modifier = Modifier.padding(top = 15.dp),
            )
        }

    }
    AlertDialog(onDismissRequest = onDismissRequest, confirmButton = {
        Button(onClick = {
            if (textFieldValue.isNotEmpty() && numberFieldValue.isNotEmpty() && quantityFieldValue.isNotEmpty()) {
                onConfirmation(
                    textFieldValue,
                    (numberFieldValue.toFloat()),
                    quantityFieldValue.toInt()
                )
            }
        }) {
            Text("Add")
        }
    }, dismissButton = {
        Button(
            onClick = onDismissRequest
        ) {
            Text("Cancel")
        }
    }, title = {
        Text(
            text = "Add new item to the list",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
            )
        )
    }, text = dialogContent
    )
}
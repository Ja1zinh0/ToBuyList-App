package com.ja1zinh0.appdecompras.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
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
    onConfirmation: () -> Unit,
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
            Text(text = "Are you sure you want to delete this card?", style = TextStyle(
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
                    onConfirmation()
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

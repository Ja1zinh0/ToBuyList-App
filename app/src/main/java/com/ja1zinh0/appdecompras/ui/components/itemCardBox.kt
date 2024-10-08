package com.ja1zinh0.appdecompras.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ja1zinh0.appdecompras.data.room.model.ItemList.ItemList
import com.ja1zinh0.appdecompras.data.room.model.itemCard.Card
import com.ja1zinh0.appdecompras.data.room.model.itemCard.ItemCard

@ExperimentalMaterial3Api
@Composable
fun ItemCardBox(
    itemCard: ItemCard,
    onDelete: (ItemCard) -> Unit,
    onUpdate: (ItemCard, String) -> Unit,
    card: ItemCard,
) {
    val currentTitle = remember { mutableStateOf(itemCard.title) }
    val totalAmount = remember { mutableStateOf(TextFieldValue("0,00")) }
    var showUpdateCardDialog by remember { mutableStateOf(false) }
    var showDeleteCardDialog by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    var activeCardId by remember { mutableStateOf<Int?>(null) }


    Card(
        modifier = Modifier
            .fillMaxWidth(0.90F)
            .padding(top = 28.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(12),
        onClick = { showBottomSheet = true
            activeCardId = itemCard.cardID
        }
    ) {
        if (activeCardId == itemCard.cardID) {
            CustomBottomSheet(
                onDismissRequest = { activeCardId = null },
                sheetState = sheetState,
                itemCard = card,
            )
        }
        Row(modifier = Modifier.height(175.dp)) {
            Column {
                Row(
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = currentTitle.value, style = TextStyle(fontSize = 24.sp))
                            Column() {
                                IconButton(modifier = Modifier.offset(y = (-10).dp),
                                    onClick = {
                                        showUpdateCardDialog = true
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Edit,
                                        contentDescription = "Edit Button",
                                        tint = Color.White
                                    )
                                }
                                IconButton(modifier = Modifier.offset(y = (-25).dp),
                                    onClick = {
                                        showDeleteCardDialog = true
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Delete,
                                        contentDescription = "Delete Button",
                                        tint = Color.White
                                    )
                                }
                            }
                            if (showUpdateCardDialog) {
                                UpdateCardAlertDialog(
                                    onDismissRequest = { showUpdateCardDialog = false },
                                    onConfirmation = { newTitle ->
                                        currentTitle.value = newTitle
                                        onUpdate(itemCard, newTitle)
                                        showUpdateCardDialog = false
                                    },
                                    dialogTitle = "Update title"
                                )
                            }
                            if (showDeleteCardDialog) {
                                DeleteCardAlertDialog(
                                    onDismissRequest = { showDeleteCardDialog = false },
                                    onConfirmation = {
                                        onDelete(itemCard)
                                        showDeleteCardDialog = false
                                    },
                                    cardID = card.cardID
                                )

                            }
                        }
                        Box(
                            modifier = Modifier
                                .padding(bottom = 10.dp)
                                .wrapContentSize(unbounded = true)
                                .clip(RoundedCornerShape(20.dp))
                                .background(color = Color(0xFFFF9E79)),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                modifier = Modifier.padding(horizontal = 8.dp),
                                text = "Total: R$ 0,00",
                                style = TextStyle(
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    fontSize = 19.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }

                }
            }
        }
    }
}
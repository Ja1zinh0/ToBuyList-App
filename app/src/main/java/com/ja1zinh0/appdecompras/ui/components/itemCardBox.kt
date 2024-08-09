package com.ja1zinh0.appdecompras.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ja1zinh0.appdecompras.model.itemCard.ItemCard

@Composable
fun ItemCardBox(
    itemCard: ItemCard,
    onDelete: (ItemCard) -> Unit,
    onUpdateTitle: (ItemCard, String) -> Unit
) {
    val currentTitle = remember { mutableStateOf(itemCard.title) }
    val totalAmount = remember { mutableStateOf(TextFieldValue("0,00")) }

    Card(
        modifier = Modifier
            .fillMaxWidth(0.90F)
            .padding(top = 28.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(12),
    ) {
        Row(modifier = Modifier.height(175.dp)) {
            Column {
                Row(
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = currentTitle.value, style = TextStyle(fontSize = 24.sp))
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
                                text = "Total: R$ 100,00",
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
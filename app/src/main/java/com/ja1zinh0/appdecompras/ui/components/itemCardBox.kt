package com.ja1zinh0.appdecompras.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.ja1zinh0.appdecompras.model.itemCard.ItemCard

@Composable
fun ItemCardBox(
        itemCard: ItemCard,
        onDelete: (ItemCard) -> Unit,
        onUpdateTitle: (ItemCard, String) -> Unit
) {

    Card(
        modifier = Modifier
        .fillMaxWidth(0.90F)
        .padding(top = 28.dp),
        colors =  CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        shape = RoundedCornerShape(12),
    ) {
        Row(modifier = Modifier.height(175.dp)) {

        }
    }
}
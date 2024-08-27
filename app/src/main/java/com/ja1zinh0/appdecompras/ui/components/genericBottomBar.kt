package com.ja1zinh0.appdecompras.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ja1zinh0.appdecompras.model.itemCard.ItemCard
import com.ja1zinh0.appdecompras.viewmodel.CardListViewModel

@Composable
fun GenericBottomBar(
    viewModel: CardListViewModel = hiltViewModel()
) {
    var showDialog by remember { mutableStateOf(false) }
    Box(Modifier.fillMaxWidth()) {
        BottomAppBar(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth(),
            containerColor = MaterialTheme.colorScheme.primary,
        ) {
        }
        Box(
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.TopCenter)
                .offset(y = (-22.5).dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = (5).dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.tertiaryContainer),
                contentAlignment = Alignment.Center,
            ) {
                IconButton(
                    modifier = Modifier.align(Alignment.Center),
                    onClick = {
                        showDialog = true
                    },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                    )
                }
                if (showDialog) {
                    CreateCardAlertDialog(
                        onDismissRequest = { showDialog = false },
                        onConfirmation = {
                            val newCard = ItemCard(title = it, cardID = 2, totalPrice = "123")
                            viewModel.addItem(newCard)
                            showDialog = false
                        },
                        dialogTitle = "Create new list?",
                    )
                }
            }
        }
    }
}

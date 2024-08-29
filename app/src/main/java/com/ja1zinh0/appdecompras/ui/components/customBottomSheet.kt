package com.ja1zinh0.appdecompras.ui.components

import android.content.ClipData
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ja1zinh0.appdecompras.data.room.model.ItemList.ItemList
import com.ja1zinh0.appdecompras.data.room.model.itemCard.ItemCard

@ExperimentalMaterial3Api
@Composable
fun CustomBottomSheet(
    onDismissRequest: () -> Unit,
    sheetState: SheetState,
    itemCard: ItemCard,
) {
    val scrollState = rememberScrollState()
    var showItemAlertDialog by remember { mutableStateOf(false) }

    ModalBottomSheet(
        onDismissRequest = { onDismissRequest() },
        Modifier.fillMaxHeight(),
        sheetState = sheetState
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = "Card ID: ${itemCard.cardID}")
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(enabled = true, state = scrollState)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = {
                        showItemAlertDialog = true
                    }) {

                        Text(text = "Add new item")
                    }
                    if (showItemAlertDialog) {
                        CreateItemAlertDialog(
                            onDismissRequest = { showItemAlertDialog = false },
                            onConfirmation = { name, value, quantity ->
                            },
                        )
                    }
                }
            }
        }
    }
}
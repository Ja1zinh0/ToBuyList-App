package com.ja1zinh0.appdecompras.ui.view.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ja1zinh0.appdecompras.model.itemCard.ItemCard
import com.ja1zinh0.appdecompras.ui.components.ItemCardBox
import com.ja1zinh0.appdecompras.ui.components.genericTopBar
import com.ja1zinh0.appdecompras.viewmodel.CardListViewModel
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun MainScreen(
    navController: NavController,
    viewModel: CardListViewModel = hiltViewModel()
){

    val cardItems by viewModel.cardItems.collectAsState()
    Scaffold(
        topBar = genericTopBar("My lists"),
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                // Aqui você pode criar um novo ItemCard
                val newCard = ItemCard(title = "teste", cardID = 2, totalPrice = "123")
                viewModel.addItem(newCard)  // Adiciona o novo item à lista
            }) {
                Text("+")  // Ícone ou texto para o botão
            }
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                LazyColumn {
                    items(cardItems){ item ->
                        ItemCardBox(
                            itemCard = item,
                            onDelete = {  },
                            onUpdateTitle = { updatedItem, newTitle ->
                                val updatedItemWithNewTitle = updatedItem.copy(title = newTitle)
                                viewModel.updateItem(updatedItemWithNewTitle)
                            },
                        )
                    }
                }
            }
        }
    )
}


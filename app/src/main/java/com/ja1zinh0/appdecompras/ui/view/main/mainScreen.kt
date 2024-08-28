package com.ja1zinh0.appdecompras.ui.view.main

import com.ja1zinh0.appdecompras.viewmodel.CardListViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ja1zinh0.appdecompras.ui.components.GenericBottomBar
import com.ja1zinh0.appdecompras.ui.components.ItemCardBox
import com.ja1zinh0.appdecompras.ui.components.genericTopBar

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: CardListViewModel = hiltViewModel()
){

    val cardItems by viewModel.cardItems.collectAsState(emptyList())
    Scaffold(
        topBar = genericTopBar("My lists"),
        bottomBar = { GenericBottomBar(viewModel) },
        containerColor = MaterialTheme.colorScheme.background,

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
                            onDelete = {viewModel.removeItem(item)},
                        )
                    }
                }
            }
        }
    )
}


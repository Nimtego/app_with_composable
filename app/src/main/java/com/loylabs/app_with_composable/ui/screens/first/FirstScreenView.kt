package com.loylabs.app_with_composable.ui.screens.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loylabs.app_with_composable.ui.common.MyScreenTitle
import com.loylabs.app_with_composable.ui.common.PrimaryButton
import com.loylabs.app_with_composable.ui.navigation.MyRouteNavigator
import com.loylabs.app_with_composable.ui.theme.ComposeTheme

@Composable
fun FirstScreen(screen1ViewModel: FirstScreenViewModel) {

    val title = screen1ViewModel.flowTitle.collectAsState(initial = "")
    val simpleItem = screen1ViewModel.flowSimpleItem.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.LightGray)
            ) {
                MyScreenTitle(
                    title = title.value
                )
            }
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Test items for lazy column",
                    style = MaterialTheme.typography.h3
                )
            }
        }
        items(simpleItem.value) { item ->
            SimpleItem(item.name, item.description, item.imageRes)
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.LightGray)
            ) {
                PrimaryButton(
                    screen1ViewModel::onEvent,
                    "Test first title"
                )
            }
        }
//        items(simpleItem.value) { plant ->
//            SimpleItem(plant.name, plant.description, plant.imageRes)
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    ComposeTheme {
        val viewModel = FirstScreenViewModel(MyRouteNavigator())
        FirstScreen(viewModel)
    }
}
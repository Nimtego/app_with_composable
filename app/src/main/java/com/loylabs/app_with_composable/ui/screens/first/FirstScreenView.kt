package com.loylabs.app_with_composable.ui.screens.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.loylabs.app_with_composable.ui.base.BaseEvent
import com.loylabs.app_with_composable.ui.common.MyScreenTitle
import com.loylabs.app_with_composable.ui.common.PrimaryButton
import com.loylabs.app_with_composable.ui.navigation.MyRouteNavigator
import com.loylabs.app_with_composable.ui.theme.ComposeTheme

@Composable
fun FirstScreen(viewModel: FirstScreenViewModel) {
//    val listState: LazyListState = if (screen1ViewModel.stateList == null) {
//        rememberLazyListState().also {
//            screen1ViewModel.stateList = it
//        }
//    } else {
//        screen1ViewModel.stateList!!
//    }
    val title = viewModel.flowTitle.collectAsState(initial = "")
    val simpleItem = viewModel.flowSimpleItem.collectAsState(initial = emptyList())

    LazyColumn(
        state = rememberLazyListState(),
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
                    { viewModel.onEvent(BaseEvent.Second) },
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
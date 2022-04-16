package com.loylabs.app_with_composable.ui.screens.list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.loylabs.app_with_composable.ui.screens.first.SimpleItem
import com.loylabs.app_with_composable.ui.theme.ComposeTheme


@Composable
fun ListScreen(viewModel: ListViewModel) {

    val scrollState = rememberScrollState()
    val listState = rememberLazyListState()

    val simpleItem = viewModel.flowCompositeItem.collectAsState(initial = emptyList())

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Test composite items",
                    style = MaterialTheme.typography.h3
                )
            }
        }

        items(simpleItem.value) { item ->
            item.PrepareView()
//            when(item) {
//                is Type1Model -> Type1ItemView(item)
//                is Type2Model -> Type2ItemView(item)
//            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.LightGray)
            ) {
                PrimaryButton(
                    { viewModel.onEvent(BaseEvent.First) },
                    "Test list title"
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
fun ListScreenPreview() {
    ComposeTheme {
        val viewModel = ListViewModel(MyRouteNavigator())
        ListScreen(viewModel)
    }
}
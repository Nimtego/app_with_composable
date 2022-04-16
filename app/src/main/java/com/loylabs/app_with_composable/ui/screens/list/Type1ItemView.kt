package com.loylabs.app_with_composable.ui.screens.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Type1ItemView(type1Model: Type1Model) {
    Card(
        modifier = Modifier.padding(4.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(corner = CornerSize(24.dp)),
        elevation = 5.dp,
        backgroundColor = Color.Gray
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = type1Model.name,
                    style = MaterialTheme.typography.h4,
                    color = Color.Blue,
                )
                Text(
                    text = type1Model.name,
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}
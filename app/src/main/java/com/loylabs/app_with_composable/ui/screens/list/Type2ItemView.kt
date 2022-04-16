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
fun Type2ItemView(type2Model: Type2Model) {
    Card(
        modifier = Modifier.padding(4.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(corner = CornerSize(4.dp)),
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = type2Model.name,
                    style = MaterialTheme.typography.h4,
                    color = Color.Red,
                )
                Text(
                    text = type2Model.name,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = type2Model.name,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = type2Model.name,
                    style = MaterialTheme.typography.body2,
                )
                Text(
                    text = type2Model.name,
                    style = MaterialTheme.typography.h4,
                    color = Color.Red,
                )
            }
        }
    }
}
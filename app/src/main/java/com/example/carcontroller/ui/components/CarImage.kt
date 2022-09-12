package com.example.carcontroller.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.carcontroller.model.Car
import com.example.carcontroller.ui.theme.Santa_Fe

@Composable
fun CarImage(
    carDetails: Car,
    modifier: Modifier,
) {
    Image(
        painter = painterResource(id = carDetails.drawableId),
        contentDescription = null,
        modifier = modifier.fillMaxWidth(0.7F).padding(vertical = 12.dp)
    )

    Row(modifier = modifier) {
        Divider(color = Santa_Fe, modifier = modifier
            .width(25.dp)
            .height(3.dp))
        Spacer(modifier = modifier.width(4.dp))
        Divider(modifier = modifier
            .width(25.dp)
            .height(3.dp))
    }
}
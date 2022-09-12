package com.example.carcontroller.ui.location

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.carcontroller.ui.components.TextNotImplemented
import com.example.carcontroller.ui.theme.Alto
import com.example.carcontroller.ui.theme.CreamColor

@Composable
fun LocationScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    CreamColor,
                    Alto
                ),
                startY = 1000F
            ))
    )
    TextNotImplemented()
}
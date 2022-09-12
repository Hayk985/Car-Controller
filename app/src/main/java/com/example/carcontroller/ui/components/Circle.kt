package com.example.carcontroller.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.carcontroller.ui.theme.White

@Composable
fun Circle(
    modifier: Modifier,
    color: Color,
    isEnabled: Boolean,
    painter: Painter,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        enabled = isEnabled,
        shape = CircleShape,
        modifier = modifier.size(80.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            contentColor = White),
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            modifier = modifier.size(36.dp, 36.dp)
        )
    }
}

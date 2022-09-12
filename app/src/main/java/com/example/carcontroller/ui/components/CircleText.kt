package com.example.carcontroller.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carcontroller.model.ClickAction
import com.example.carcontroller.ui.theme.White

@Composable
fun TextCircle(
    modifier: Modifier,
    color: Color,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        shape = CircleShape,
        modifier = modifier.size(80.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            contentColor = White)
    ) {
        Text(
            text = text.uppercase(),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}
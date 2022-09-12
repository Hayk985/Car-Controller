package com.example.carcontroller.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.carcontroller.R
import com.example.carcontroller.ui.theme.CreamColor
import com.example.carcontroller.ui.theme.Gray

@Composable
fun TextNotImplemented() {
    Box(
        modifier = Modifier.fillMaxSize().background(CreamColor),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.not_implemented),
            color = Gray,
            fontStyle = FontStyle.Italic,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
    }
}
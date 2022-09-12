package com.example.carcontroller.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carcontroller.R
import com.example.carcontroller.ui.theme.Gray

@Composable
fun RefreshComponent(
    modifier: Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(vertical = 24.dp).fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.btn_refresh),
            contentDescription = null
        )
        Spacer(modifier = modifier.width(4.dp))
        Text(
            text = stringResource(id = R.string.last_updated),
            fontSize = 12.sp,
            color = Gray,
            fontWeight = FontWeight.Bold
        )
    }
}
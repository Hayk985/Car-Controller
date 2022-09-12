package com.example.carcontroller.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carcontroller.R
import com.example.carcontroller.model.ClickAction
import com.example.carcontroller.ui.theme.Black
import com.example.carcontroller.ui.theme.Gray
import com.example.carcontroller.ui.theme.White

@Composable
fun EngineContainer(
    modifier: Modifier,
    onClick: (ClickAction) -> Unit,
) {
    Column(modifier = modifier) {
        Row(
            modifier = modifier.wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.engine),
                fontSize = 16.sp,
                color = Black,
                fontWeight = FontWeight.Bold)
            Spacer(modifier = modifier.width(4.dp))
            Divider(color = Gray, modifier = modifier
                .padding(vertical = 2.dp)
                .height(16.dp)
                .width(2.dp))
            Spacer(modifier = modifier.width(4.dp))
            Text(
                text = stringResource(id = R.string.engine_stopped),
                fontSize = 12.sp,
                color = Gray)
        }
        Spacer(modifier = modifier.height(4.dp))
        Box(
            modifier = modifier
                .wrapContentSize()
                .clip(MaterialTheme.shapes.large)
                .background(color = White),
            contentAlignment = Alignment.Center)
        {
            Row(modifier = modifier.padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = modifier.width(8.dp))
                TextCircle(
                    modifier = modifier,
                    color = Black,
                    text = stringResource(id = R.string.engine_start),
                    onClick = { onClick(ClickAction.START_ENGINE) }
                )
                Spacer(modifier = modifier.width(8.dp))
                TextCircle(
                    modifier = modifier,
                    color = Black,
                    text = stringResource(id = R.string.engine_stop),
                    onClick = { onClick(ClickAction.STOP_ENGINE) }
                )
                Spacer(modifier = modifier.width(8.dp))
            }
        }
    }
}
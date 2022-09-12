package com.example.carcontroller.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carcontroller.R
import com.example.carcontroller.model.Car
import com.example.carcontroller.ui.theme.Black
import com.example.carcontroller.ui.theme.Santa_Fe
import com.example.carcontroller.ui.theme.White

@Composable
fun TopBar(
    carDetails: Car,
    modifier: Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = White)
            .padding(vertical = 12.dp),
    ) {
        Text(
            text = carDetails.name,
            fontSize = 26.sp,
            color = Black,
            fontWeight = FontWeight.Light,
            modifier = modifier
        )

        Spacer(modifier = modifier.width(12.dp))
        Divider(color = Santa_Fe, modifier = modifier.size(2.dp, 24.dp))
        Spacer(modifier = modifier.width(8.dp))

        Icon(
            painter = painterResource(id = R.drawable.notif_gas),
            contentDescription = null
        )

        Text(
            text = stringResource(id = R.string.gas_ml, carDetails.gas),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Black
        )
    }
}
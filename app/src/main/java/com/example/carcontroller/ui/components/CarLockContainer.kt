package com.example.carcontroller.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carcontroller.R
import com.example.carcontroller.model.ClickAction
import com.example.carcontroller.model.CarLockState
import com.example.carcontroller.model.LockState
import com.example.carcontroller.ui.theme.Black
import com.example.carcontroller.ui.theme.Gray
import com.example.carcontroller.ui.theme.Santa_Fe
import com.example.carcontroller.ui.theme.White

@Composable
fun CarLockContainer(
    modifier: Modifier,
    carLockState: CarLockState,
    onClick: (ClickAction) -> Unit,
) {
    Column(modifier = modifier) {
        Row(
            modifier = modifier.wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.doors),
                fontSize = 16.sp,
                color = Black,
                fontWeight = FontWeight.Bold)

            Spacer(modifier = modifier.width(4.dp))
            if (carLockState != CarLockState.NoLockState) {
                Divider(color = Gray, modifier = modifier
                    .padding(vertical = 2.dp)
                    .height(16.dp)
                    .width(2.dp))
                Spacer(modifier = modifier.width(4.dp))

                Text(
                    text = if (carLockState is CarLockState.LockStateChanging) {
                        stringResource(id = R.string.dots)
                    } else {
                        if (carLockState.lockState == LockState.LOCK) {
                            stringResource(id = R.string.car_locked)
                        } else {
                            stringResource(id = R.string.car_unlocked)
                        }
                    },
                    fontSize = 12.sp,
                    color = Gray)
            }
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

                if (carLockState is CarLockState.LockStateChanging &&
                    carLockState.lockState == LockState.LOCK
                ) {
                    CircularProgress(modifier = modifier)
                } else {
                    Circle(
                        modifier = modifier,
                        color = if (carLockState is CarLockState.LockStateChanged &&
                            carLockState.lockState == LockState.LOCK
                        ) Santa_Fe
                         else Black,
                        isEnabled = carLockState !is CarLockState.LockStateChanging,
                        painter = painterResource(id = R.drawable.act_lock),
                        onClick = { onClick(ClickAction.LOCK_CAR) }
                    )
                }

                Spacer(modifier = modifier.width(8.dp))

                if (carLockState is CarLockState.LockStateChanging &&
                    carLockState.lockState == LockState.UNLOCK
                ) {
                    CircularProgress(modifier = modifier)
                } else {
                    Circle(
                        modifier = modifier,
                        color = if (carLockState is CarLockState.LockStateChanged &&
                            carLockState.lockState == LockState.UNLOCK
                        ) Santa_Fe
                        else Black,
                        isEnabled = carLockState !is CarLockState.LockStateChanging,
                        painter = painterResource(id = R.drawable.act_unlock),
                        onClick = { onClick(ClickAction.UNLOCK_CAR) }
                    )
                }

                Spacer(modifier = modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun CircularProgress(
    modifier: Modifier
) {
    CircularProgressIndicator(
        modifier = modifier.size(80.dp, 80.dp),
        color = Santa_Fe,
        strokeWidth = 3.dp
    )
}
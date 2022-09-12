package com.example.carcontroller.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.carcontroller.R
import com.example.carcontroller.model.ClickAction
import com.example.carcontroller.ui.theme.Blue
import com.example.carcontroller.ui.theme.White

@Composable
fun DialogComponent(
    showDialog: Boolean,
    clickAction: ClickAction?,
    carName: String,
    onDialogDismissListener: () -> Unit,
    onDialogSuccessListener: () -> Unit,
) {
    if (showDialog && clickAction != null) {
        AlertDialog(
            onDismissRequest = {
                onDialogDismissListener()
            },
            title = {
                Text(
                    text = stringResource(id = R.string.dialog_title),
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(text = stringResource(id = R.string.dialog_description,
                    if (clickAction == ClickAction.LOCK_CAR) "lock" else "unlock",
                    carName)
                )
            },
            confirmButton = {
                Button(
                    onClick = { onDialogSuccessListener() },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Blue)
                ) {
                    Text(text = stringResource(
                        id = R.string.dialog_action_positive,
                        if (clickAction == ClickAction.LOCK_CAR) "Lock" else "Unlock"),
                        color = White)
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = { onDialogDismissListener() },
                    colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
                    border = BorderStroke(0.dp, Color.Transparent),
                ) {
                    Text(text = stringResource(id = R.string.dialog_action_negative),
                        color = Blue)
                }
            }
        )
    }
}
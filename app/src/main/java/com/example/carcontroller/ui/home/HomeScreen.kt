package com.example.carcontroller.ui.home

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carcontroller.R
import com.example.carcontroller.model.CarLockState
import com.example.carcontroller.model.ClickAction
import com.example.carcontroller.model.LockState
import com.example.carcontroller.ui.components.*
import com.example.carcontroller.ui.theme.Alto
import com.example.carcontroller.ui.theme.CreamColor
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val carDetails = viewModel.getCarDetails()
    val carLockState: CarLockState by viewModel.carLockStateFlow.collectAsState()

    var showDialog: Boolean by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val snackBarState = viewModel.snackBarState
    val snackBarHostState = remember {
        SnackbarHostState()
    }

    var clickAction: ClickAction? by rememberSaveable {
        mutableStateOf(null)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    CreamColor,
                    Alto
                ),
                startY = 1000F
            )
        )
    ) {
        Column(
            Modifier.fillMaxWidth(),
        ) {
            TopBar(carDetails = carDetails, modifier = Modifier)
            RefreshComponent(modifier = Modifier)
            CarImage(carDetails = carDetails, modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(48.dp))

            Row(modifier = Modifier, horizontalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier.width(8.dp))
                CarLockContainer(
                    modifier = Modifier,
                    carLockState = carLockState,
                    onClick = { action ->
                        if (carLockState is CarLockState.LockStateChanged) {
                            if ((action == ClickAction.LOCK_CAR &&
                                    carLockState.lockState == LockState.LOCK) ||
                                (action == ClickAction.UNLOCK_CAR &&
                                    carLockState.lockState == LockState.UNLOCK)
                            ) return@CarLockContainer
                        }

                        clickAction = action
                        showDialog = true
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                EngineContainer(
                    modifier = Modifier,
                    onClick = { action ->
                        Toast.makeText(
                            context,
                            if (action == ClickAction.START_ENGINE)
                                context.getString(R.string.message_start_engine)
                            else context.getString(R.string.message_stop_engine),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            // Show SnackBar if needed
            if (snackBarState.value) {
                snackBarState.value = false
                scope.launch {
                    snackBarHostState.showSnackbar(
                        if (carLockState.lockState == LockState.LOCK)
                            context.getString(R.string.message_car_locked)
                        else context.getString(R.string.message_car_unlocked),
                        duration = SnackbarDuration.Short
                    )
                }
            }

            DefaultSnackBar(
                modifier = Modifier,
                snackBarHostState = snackBarHostState
            )
        }
    }

    DialogComponent(
        showDialog = showDialog,
        clickAction = clickAction,
        carName = carDetails.name,
        onDialogDismissListener = {
            showDialog = false
        },
        onDialogSuccessListener = {
            showDialog = false
            viewModel.changeCarLockState(
                clickAction == ClickAction.LOCK_CAR
            )
        }
    )
}
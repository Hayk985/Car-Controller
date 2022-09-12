package com.example.carcontroller.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.carcontroller.R

@Composable
fun DefaultSnackBar(
    modifier: Modifier,
    snackBarHostState: SnackbarHostState,
) {
    ConstraintLayout(modifier = modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp)
    ) {
        val snackBar = createRef()
        SnackbarHost(
            modifier = modifier
                .padding(bottom = 8.dp)
                .constrainAs(snackBar) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            hostState = snackBarHostState,
            snackbar = {
                Snackbar(modifier = Modifier
                    .padding(bottom = 8.dp)
                    .constrainAs(snackBar) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                ) {
                    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
                        val text = createRef()
                        val icon = createRef()
                        Text(
                            text = snackBarHostState.currentSnackbarData?.message ?: "",
                            modifier = modifier.constrainAs(text) {
                                start.linkTo(parent.start)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.sym_check_fill),
                            contentDescription = null,
                            modifier = modifier.constrainAs(icon) {
                                end.linkTo(parent.end)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                        )
                    }
                }
            }
        )
    }
}
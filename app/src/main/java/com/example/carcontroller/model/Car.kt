package com.example.carcontroller.model

import androidx.annotation.IntegerRes

data class Car(
    val name: String,
    @IntegerRes val drawableId: Int,
    val gas: Int,
)

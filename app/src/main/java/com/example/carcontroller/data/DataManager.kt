package com.example.carcontroller.data

import com.example.carcontroller.R
import com.example.carcontroller.model.Car

class DataManager {
    private val car: Car = Car(NAME, DRAWABLE_ID, GAS)

    fun getCarDetails(): Car = car

    private companion object {
        private const val NAME = "Mercedes"
        private const val DRAWABLE_ID = R.drawable.car
        private const val GAS = 45
    }
}
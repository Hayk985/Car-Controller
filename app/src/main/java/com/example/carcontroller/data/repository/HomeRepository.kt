package com.example.carcontroller.data.repository

import com.example.carcontroller.data.DataManager
import com.example.carcontroller.model.Car
import javax.inject.Inject

interface HomeRepository {
    fun getCarDetails(): Car
}

class HomeRepositoryImpl @Inject constructor(
    private val dataManager: DataManager,
) : HomeRepository {

    override fun getCarDetails(): Car {
        return dataManager.getCarDetails()
    }
}
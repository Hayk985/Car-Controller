package com.example.carcontroller.ui.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.carcontroller.ui.home.HomeScreen
import com.example.carcontroller.ui.location.LocationScreen
import com.example.carcontroller.ui.settings.SettingsScreen
import com.example.carcontroller.ui.vehicle.VehicleScreen
import com.example.carcontroller.utils.Constants

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Constants.ROUTE_HOME
    ) {
        composable(route = Constants.ROUTE_HOME) {
            HomeScreen()
        }
        composable(route = Constants.ROUTE_VEHICLE) {
            VehicleScreen()
        }
        composable(route = Constants.ROUTE_LOCATION) {
            LocationScreen()
        }
        composable(route = Constants.ROUTE_SETTINGS) {
            SettingsScreen()
        }
    }
}
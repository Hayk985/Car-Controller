package com.example.carcontroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.carcontroller.model.BottomNavItem
import com.example.carcontroller.ui.components.BottomNavigationBar
import com.example.carcontroller.ui.components.Navigation
import com.example.carcontroller.ui.theme.CarControllerTheme
import com.example.carcontroller.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarControllerTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = stringResource(id = R.string.tab_home),
                                    route = Constants.ROUTE_HOME,
                                    icon = Icons.Default.Home
                                ),
                                BottomNavItem(
                                    name = stringResource(id = R.string.tab_vehicle),
                                    route = Constants.ROUTE_VEHICLE,
                                    icon = ImageVector.vectorResource(id = R.drawable.ic_vehicle)
                                ),
                                BottomNavItem(
                                    name = stringResource(id = R.string.tab_location),
                                    route = Constants.ROUTE_LOCATION,
                                    icon = Icons.Default.LocationOn
                                ),
                                BottomNavItem(
                                    name = stringResource(id = R.string.tab_settings),
                                    route = Constants.ROUTE_SETTINGS,
                                    icon = Icons.Default.Settings
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}
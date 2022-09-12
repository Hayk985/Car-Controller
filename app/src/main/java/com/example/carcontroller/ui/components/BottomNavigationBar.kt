package com.example.carcontroller.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.carcontroller.model.BottomNavItem
import com.example.carcontroller.ui.theme.Black
import com.example.carcontroller.ui.theme.Santa_Fe
import com.example.carcontroller.ui.theme.White

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit,
) {
    val backStackEntry = navController.currentBackStackEntryAsState()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = White,
        elevation = 8.dp
    ) {
        items.forEach { item ->
            val isSelected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = isSelected,
                onClick = { onItemClick(item) },
                selectedContentColor = Santa_Fe,
                unselectedContentColor = White,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (isSelected) {
                            Divider(color = Santa_Fe, modifier = modifier
                                .fillMaxWidth(0.5F)
                                .width(4.dp))
                        }
                        Spacer(modifier = modifier.height(8.dp))
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name,
                            tint = if (isSelected) Santa_Fe else Black
                        )

                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp,
                            color = if (isSelected) Santa_Fe else Black
                        )

                        Spacer(modifier = modifier.height(8.dp))
                    }
                }
            )
        }
    }
}
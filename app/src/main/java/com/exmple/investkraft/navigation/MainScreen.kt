package com.exmple.investkraft.navigation


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.exmple.investkraft.navigation.BottomNavigationBar
import com.exmple.investkraft.screen.ContentScreen

import com.exmple.investkraft.screen.LeadsScreen
import com.exmple.investkraft.screen.QRCodeScreen
import com.exmple.investkraft.screen.home.HomeScreen


@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = { tab ->
                    selectedTab = tab
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedTab) {
                0 -> HomeScreen()
                1 -> LeadsScreen()
                2 -> QRCodeScreen()
                3 -> ContentScreen()
            }
        }
    }
}

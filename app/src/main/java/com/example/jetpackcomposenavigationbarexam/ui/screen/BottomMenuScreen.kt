package com.example.jetpackcomposenavigationbarexam.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposenavigationbarexam.data.NavigationData
import com.example.jetpackcomposenavigationbarexam.ui.screen.bottom.HomeScreen
import com.example.jetpackcomposenavigationbarexam.ui.screen.bottom.ListScreen
import com.example.jetpackcomposenavigationbarexam.ui.screen.bottom.MyScreen
import com.example.jetpackcomposenavigationbarexam.ui.screen.bottom.SearchScreen
import com.example.jetpackcomposenavigationbarexam.ui.theme.JetpackComposeNavigationBarExamTheme
import com.guru.fontawesomecomposelib.FaIcon
import com.guru.fontawesomecomposelib.FaIcons

@Composable
fun BottomMenuScreen(navController: NavController) {
    val navMenus = listOf(
        NavigationData("홈", FaIcons.Home),
        NavigationData("검색", FaIcons.Search),
        NavigationData("목록", FaIcons.List),
        NavigationData("My", FaIcons.User)
    )

    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    navMenus.forEachIndexed { index, menu ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable { selectedItem = index }
                        ) {
                            FaIcon(
                                faIcon = menu.icon,
                                tint = if (selectedItem == index) Color.Black else Color.Gray,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.padding(2.dp))

                            Text(
                                text = menu.title,
                                color = if (selectedItem == index) Color.Black else Color.Gray
                            )
                        }
                    }

                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            when (selectedItem) {
                0 -> HomeScreen()
                1 -> SearchScreen()
                2 -> ListScreen()
                3 -> MyScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomMenuScreenPreview() {
    val navController = rememberNavController()
    JetpackComposeNavigationBarExamTheme {
        BottomMenuScreen(navController)
    }
}
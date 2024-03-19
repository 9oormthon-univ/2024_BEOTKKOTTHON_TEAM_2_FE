package com.mukatlist.mukatlist.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mukatlist.mukatlist.data.BottomNavItems
import com.mukatlist.mukatlist.screen.CalendarScreen
import com.mukatlist.mukatlist.screen.GroupMukatlistScreen
import com.mukatlist.mukatlist.screen.MukatlistScreen
import com.mukatlist.mukatlist.screen.MyPageScreen
import com.mukatlist.mukatlist.screen.SearchMusteatScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItems.Mukatlist.route) {
        composable(BottomNavItems.Mukatlist.route) {
            MukatlistScreen()
        }
        composable(BottomNavItems.GroupMukatlist.route) {
            GroupMukatlistScreen()
        }
        composable(BottomNavItems.SearchMusteat.route) {
            SearchMusteatScreen()
        }
        composable(BottomNavItems.Calendar.route) {
            CalendarScreen()
        }
        composable(BottomNavItems.MyPage.route) {
            MyPageScreen()
        }
    }

//    NavHost(navController = navController, startDestination = TopNavItem.Top.route) {
//        composable(TopNavItem.Top.route) {
//            MukatlistScreen()
//        }
//    }
}
package com.mukatlist.mukatlist.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mukatlist.mukatlist.data.BottomNavItems
import com.mukatlist.mukatlist.data.TopNavItem
import com.mukatlist.mukatlist.data.Top_MypageNavItem
import com.mukatlist.mukatlist.screen.CalendarScreen
import com.mukatlist.mukatlist.screen.GroupMukatlistScreen
import com.mukatlist.mukatlist.screen.MukatlistScreen
import com.mukatlist.mukatlist.screen.MyPageScreen
import com.mukatlist.mukatlist.screen.SearchMusteatScreen

@Composable
fun Navigation_Bottom(navController: NavHostController) {
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

}
@Composable
fun Navigation_Top(navController: NavHostController) {
    NavHost(navController = navController, startDestination = TopNavItem.Top.route) {
        composable(TopNavItem.Top.route) {
            MukatlistScreen()
        }
    }
}

@Composable
fun Navigation_Top_Mypage(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Top_MypageNavItem.Top.route) {
        composable(Top_MypageNavItem.Top.route) {
            MukatlistScreen()
        }
    }
}
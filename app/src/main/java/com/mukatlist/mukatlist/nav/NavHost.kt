package com.mukatlist.mukatlist.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mukatlist.mukatlist.LoginActivity
import com.mukatlist.mukatlist.MainActivity
import com.mukatlist.mukatlist.data.BottomNavItems
import com.mukatlist.mukatlist.data.TopNavItem
import com.mukatlist.mukatlist.data.Top_MypageNavItem
import com.mukatlist.mukatlist.initSetting.profile
import com.mukatlist.mukatlist.initSetting.search_university
import com.mukatlist.mukatlist.initSetting.set_university
import com.mukatlist.mukatlist.login.LoginScreen
import com.mukatlist.mukatlist.screen.CalendarScreen
import com.mukatlist.mukatlist.screen.GroupMukatlistScreen
import com.mukatlist.mukatlist.screen.MukatlistScreen
import com.mukatlist.mukatlist.screen.MyPageScreen
import com.mukatlist.mukatlist.screen.SearchMusteatScreen
import com.mukatlist.mukatlist.ui.theme.SEARCHUNIVERSITY
import com.mukatlist.mukatlist.ui.theme.SETNAME
import com.mukatlist.mukatlist.ui.theme.SETUNIVERSITY

@Composable
fun Navigation_Bottom(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(BottomNavItems.Mukatlist.route) {
            MukatlistScreen()
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

        composable(TopNavItem.Top.route) {
            MukatlistScreen()
        }

        composable(Top_MypageNavItem.Top.route) {
            MukatlistScreen()
        }

        composable(SETNAME) {
            profile(navController)
        }
        composable(SETUNIVERSITY) {
            set_university(navController)
        }

        composable(SEARCHUNIVERSITY){
            search_university(navController)
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

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = SETNAME) {
        composable(SETNAME) {
            profile(navController)
        }
        composable(SETUNIVERSITY) {
            set_university(navController)
        }

        composable(SEARCHUNIVERSITY){
            search_university(navController)
        }
    }
}
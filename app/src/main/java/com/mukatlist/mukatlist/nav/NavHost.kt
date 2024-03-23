package com.mukatlist.mukatlist.nav

import android.content.Context
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import com.mukatlist.mukatlist.screen.MukatlistScreen
import com.mukatlist.mukatlist.screen.MyPageScreen
import com.mukatlist.mukatlist.screen.SearchMusteatScreen
import com.mukatlist.mukatlist.ui.theme.SEARCHUNIVERSITY
import com.mukatlist.mukatlist.ui.theme.SETNAME
import com.mukatlist.mukatlist.ui.theme.SETUNIVERSITY

@Composable
fun Navigation_Bottom(navController: NavHostController, startDestination: String, context: Context) {
    val time = 700
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = BottomNavItems.Mukatlist.route,
            enterTransition = {
                fadeIn(animationSpec = tween(time))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(time))
            },
            popEnterTransition = {
                fadeIn(animationSpec = tween(time))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(time))

            }
        ) {
            MukatlistScreen(context)
        }
        composable(
            route = BottomNavItems.SearchMusteat.route,
            enterTransition = {
                fadeIn(animationSpec = tween(time))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(time))
            },
            popEnterTransition = {
                fadeIn(animationSpec = tween(time))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(time))
            }
        ) {
            SearchMusteatScreen()
        }
        composable(
            route = BottomNavItems.Calendar.route,
            enterTransition = {
                fadeIn(animationSpec = tween(time))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(time))
            },
            popEnterTransition = {
                fadeIn(animationSpec = tween(time))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(time))
            }
        ) {
            CalendarScreen()
        }
        composable(
            route = BottomNavItems.MyPage.route,
            enterTransition = {
                fadeIn(animationSpec = tween(time))
            },
            exitTransition = {
                fadeOut(animationSpec = tween(time))
            },
            popEnterTransition = {
                fadeIn(animationSpec = tween(time))
            },
            popExitTransition = {
                fadeOut(animationSpec = tween(time))
            }
        ) {
            MyPageScreen()
        }

//        composable(Top_MypageNavItem.Top.route) {
//            MukatlistScreen()
//        }

        composable(SETNAME) {
            profile(navController, context)
        }
        composable(SETUNIVERSITY) {
            set_university(navController)
        }

        composable(SEARCHUNIVERSITY){
            search_university(navController)
        }


    }

}

//
//@Composable
//fun Navigation_Top_Mypage(navController: NavHostController) {
//    NavHost(navController = navController, startDestination = Top_MypageNavItem.Top.route) {
//        composable(Top_MypageNavItem.Top.route) {
//            MukatlistScreen()
//        }
//    }
//}

@Composable
fun Navigation(navController: NavHostController, context: Context) {

    NavHost(navController = navController, startDestination = SETNAME) {
        composable(SETNAME) {
            profile(navController, context)
        }
        composable(SETUNIVERSITY) {
            set_university(navController)
        }

        composable(SEARCHUNIVERSITY){
            search_university(navController)
        }
    }
}
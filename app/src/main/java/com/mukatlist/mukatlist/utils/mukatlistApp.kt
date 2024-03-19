package com.mukatlist.mukatlist.utils

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mukatlist.mukatlist.nav.BottomNavigationBar
import com.mukatlist.mukatlist.nav.Navigation
import com.mukatlist.mukatlist.nav.TopNavigationBar
import com.mukatlist.mukatlist.nav.items
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import org.intellij.lang.annotations.PrintFormat

@Composable
fun MukatlistApp() {
    val navController = rememberNavController()
    mukatNavi(
        navController = navController
    )
}

@Composable
fun mukatNavi(
    navController: NavHostController
){
    val activity = (LocalContext.current as Activity)

    Scaffold(
        topBar = {
            TopNavigationBar(
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                })
        },
        bottomBar = {
            BottomNavigationBar(
                items = items,
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                })
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
            {
                Navigation(navController = navController)
            }
        }
    )
}

@Preview
@Composable
fun mukatlistPreview(){
    MukatlistTheme {
        MukatlistApp()
    }
}
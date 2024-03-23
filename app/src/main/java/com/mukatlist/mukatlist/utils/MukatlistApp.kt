package com.mukatlist.mukatlist.utils

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mukatlist.mukatlist.nav.BottomNavigationBar
import com.mukatlist.mukatlist.nav.items
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.mukatlist.mukatlist.nav.Navigation_Bottom
import com.mukatlist.mukatlist.ui.theme.MUKATLIST
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme

@Composable
fun MukatlistApp(context: Context) {
    val navController = rememberNavController()
    mukatNavi(
        navController = navController,
        context
    )
}

@Composable
fun mukatNavi(
    navController: NavHostController,
    context: Context
){
    Scaffold(
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
                Navigation_Bottom(navController = navController, MUKATLIST, context)
            }
        }
    )
}

@Preview
@Composable
fun mukatlistPreview(){
    MukatlistTheme {
        //MukatlistApp()
    }
}
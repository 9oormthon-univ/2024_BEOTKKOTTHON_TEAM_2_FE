package com.mukatlist.mukatlist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mukatlist.mukatlist.initSetting.profile
import com.mukatlist.mukatlist.nav.BottomNavigationBar
import com.mukatlist.mukatlist.nav.Navigation_Bottom
import com.mukatlist.mukatlist.nav.items
import com.mukatlist.mukatlist.screen.setProfileScreen
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.ui.theme.SETNAME
import com.mukatlist.mukatlist.utils.mukatNavi
import com.mukatlist.mukatlist.viewmodels.SignInViewModel

class SignInActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            run()
        }

    }
}

@Composable
fun run(){
    val navController = rememberNavController()
    SignIn(
        navController = navController
    )
}


@Composable
fun SignIn(
    navController: NavHostController
){
    val activity = (LocalContext.current as Activity)

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
            {
                Navigation_Bottom(navController = navController, SETNAME)
            }
        }
    )
}

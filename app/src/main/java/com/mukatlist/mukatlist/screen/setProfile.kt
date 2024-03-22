package com.mukatlist.mukatlist.screen

import android.content.Intent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mukatlist.mukatlist.LoginActivity
import com.mukatlist.mukatlist.initSetting.profile
import com.mukatlist.mukatlist.ui.theme.SETNAME
import com.mukatlist.mukatlist.ui.theme.SETUNIVERSITY
import com.mukatlist.mukatlist.viewmodels.SignInViewModel
import javax.sql.DataSource

enum class setProfileScreen(val title: String) {
    Name(title = SETNAME),
    Uni(title = SETUNIVERSITY)
}

@Composable
fun setProfile(
    viewModel: SignInViewModel,
    navController: NavHostController = rememberNavController()
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = setProfileScreen.valueOf(
        backStackEntry?.destination?.route ?: setProfileScreen.Name.name
    )

}
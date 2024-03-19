package com.mukatlist.mukatlist.nav

import androidx.compose.foundation.Image
import com.mukatlist.mukatlist.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mukatlist.mukatlist.data.TopNavItem
import com.mukatlist.mukatlist.data.userData
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (TopNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    CenterAlignedTopAppBar(
        title = { Text(text = TopNavItem.Top.university) },
        navigationIcon = {
            IconButton(onClick = {/* DO SOMETHING*/ }){
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20 .dp)
                )
            }
        }
    )
}

@Preview
@Composable
fun TopPreview(){
    MukatlistTheme {
        val navController = rememberNavController()
        TopNavigationBar(
            navController = navController,
            onItemClick = {
                navController.navigate(it.route)
            })
    }
}
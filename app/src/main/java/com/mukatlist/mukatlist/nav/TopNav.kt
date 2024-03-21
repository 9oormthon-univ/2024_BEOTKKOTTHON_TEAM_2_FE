package com.mukatlist.mukatlist.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import com.mukatlist.mukatlist.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mukatlist.mukatlist.data.TopNavItem
import com.mukatlist.mukatlist.data.Top_MypageNavItem
import com.mukatlist.mukatlist.data.userData
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.ui.theme.font_pt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NomalTopNavigationBar(
    navController: NavHostController,
    onItemClick: (Top_MypageNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontFamily = font_pt,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 15.sp
                        )
                    ){
                        //TopNavItem.Top.getUniversity()
                        append(userData.user.getUniversity_data())
                    }
                },
            )
        },
        navigationIcon = {
            IconButton(onClick = {/* TODO */ }){
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                        .clickable {
                            /*TODO*/
                        }
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MypageTopNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (TopNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.ic_mukat),
                contentDescription = null)
            },
        navigationIcon = {
            IconButton(onClick = {/* TODO */ }){
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                        .clickable {
                            /*TODO*/
                        }
                )
            }
        },
        actions = {
            Image(
                painter = painterResource(id = R.drawable.ic_logo_point),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable {
                        /*TODO*/
                    }
            )
        }
    )
}

@Preview
@Composable
fun NomalTopNavigationBar_Preview(){
    MukatlistTheme {
        val navController = rememberNavController()
        NomalTopNavigationBar(
            navController = navController,
            onItemClick = {
                navController.navigate(it.route)
            })
    }
}

@Preview
@Composable
fun MypageTopNavigationBar_Preveiw(){
    MukatlistTheme {
        val navController = rememberNavController()
        MypageTopNavigationBar(
            navController = navController,
            onItemClick = {
                navController.navigate(it.route)
            })
    }
}
package com.mukatlist.mukatlist.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
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
import com.mukatlist.mukatlist.data.BottomNavItems
import com.mukatlist.mukatlist.ui.theme.Color_Selected
import com.mukatlist.mukatlist.ui.theme.Color_Unelected
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme

val items = listOf<BottomNavItems>(
    BottomNavItems.Mukatlist,
    BottomNavItems.GroupMukatlist,
    BottomNavItems.SearchMusteat,
    BottomNavItems.Calendar,
    BottomNavItems.MyPage
)

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItems>,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItems) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        elevation = 5.dp
    ) {
        // items 배열에 담긴 모든 항목을 추가합니다.
        items.forEach { item ->
            // 뷰의 활동 상태를 백스택에 담아 저장합니다.
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                selectedContentColor = Color_Selected,
                unselectedContentColor = Color_Unelected,
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        if (!selected){
                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(24.dp)
                                        .height(24.dp)
                                )
                                Text(text = stringResource(id = item.name),

                                    textAlign = TextAlign.Center,
                                    fontSize = 10.sp,
                                    color = Color_Unelected)

                            }
                        }
                        // 아이콘이 선택 되었을 때
                        else {
                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = item.icon_selected),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .width(24.dp)
                                        .height(24.dp)
                                )
                                Text(text = stringResource(id = item.name),
                                    textAlign = TextAlign.Center,
                                    fontSize = 10.sp,
                                    color = Color_Selected)
                            }

                        }
                    }
                },
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    } }
            )
        }
    }
}

@Preview
@Composable
fun BottomPreview(){
    MukatlistTheme {
        val navController = rememberNavController()
        BottomNavigationBar(items = items,
            navController = navController,
            onItemClick = {
                navController.navigate(it.route)
            })
    }
}
package com.mukatlist.mukatlist.initSetting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mukatlist.mukatlist.R
import com.mukatlist.mukatlist.data.TopNavItem
import com.mukatlist.mukatlist.ui.theme.Color_Unelected
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.ui.theme.Search_Bar

@Composable
fun search_university(){
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        TopSearchBar()
        Column (
            modifier = Modifier
                .background(Color.White)
                .padding(all = 10.dp)
        ){
            search_bar()
            LazyColumn {
                /* 대학교 리스트 받아오기 */
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopSearchBar() {
    Box(modifier = Modifier.fillMaxWidth())
    {
        CenterAlignedTopAppBar(
            title = {
                Image(
                    painter = painterResource(R.drawable.ic_mukat),
                    contentDescription = null
                )
            },
            navigationIcon = {
                IconButton(onClick = {/* DO SOMETHING*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = null,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                    )
                }
            }
        )
    }
}

@Composable
fun search_bar(){
    var textState by remember { mutableStateOf("") }

    BasicTextField(
        value = textState,
        onValueChange = {if (it.length > 30) textState else textState = it},
        textStyle = TextStyle(fontSize = 20.sp),
        decorationBox = {innerTextField ->
            Row (modifier = Modifier
                .background(
                    color = Search_Bar,
                    shape = RoundedCornerShape(size = 20.dp)
                )
                .fillMaxWidth()
                .padding(all = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = Color_Unelected
                )
                Spacer(modifier = Modifier.padding(all = 10.dp))
                Box(
                    modifier = Modifier.fillMaxWidth()
                ){
                    if(textState.isEmpty())
                        Text(
                            text = "대학교를 입력해주세요.",
                            color = Color_Unelected,
                            modifier = Modifier.fillMaxWidth()
                        )
                    innerTextField()
                }
            }
        },
        modifier = Modifier.padding(bottom = 3.dp)
    )
}


@Preview(showBackground = true)
@Composable
internal fun search_university_preview(){
    MukatlistTheme{
        search_university()
    }
}


@Preview(showBackground = true)
@Composable
internal fun search_preview(){
    MukatlistTheme{
        search_bar()
    }
}
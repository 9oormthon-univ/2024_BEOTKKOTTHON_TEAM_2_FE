package com.mukatlist.mukatlist.initSetting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.ui.theme.Orange01
import com.mukatlist.mukatlist.R
import com.mukatlist.mukatlist.ui.theme.Color_Unelected
import com.mukatlist.mukatlist.ui.theme.SEARCHUNIVERSITY


@Composable
fun set_university(
    navController: NavHostController
){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_ex_university),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth( )
            )
            Text(
                fontWeight = FontWeight.SemiBold,
                text = "나의 대학교를 검색해 주세요!",
                color = Color_Unelected,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
            )
            Button(
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Orange01),
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    navController.navigate(SEARCHUNIVERSITY) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            ) {
                Text(text = "대학교 검색")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun set_university_preview(){
    MukatlistTheme{
        //set_university()
    }
}
package com.mukatlist.mukatlist.initSetting

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mukatlist.mukatlist.MainActivity
import com.mukatlist.mukatlist.MainApplication
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.R
import com.mukatlist.mukatlist.ui.theme.Color_Unelected
import com.mukatlist.mukatlist.ui.theme.Orange01
import com.mukatlist.mukatlist.ui.theme.SEARCHUNIVERSITY
import com.mukatlist.mukatlist.ui.theme.SETUNIVERSITY
import com.mukatlist.mukatlist.ui.theme.font_pt
import com.mukatlist.mukatlist.viewmodels.SignInViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun profile(
    navController: NavHostController
){
    var textState by remember { mutableStateOf("") }

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    Row(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically,) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "프로필 설정")
            gallery()

            // -------------------------------------------------------------------------

            BasicTextField(
                value = textState,
                onValueChange = {if (it.length > 10) textState else textState = it},
                textStyle = TextStyle(fontSize = 20.sp, textAlign = TextAlign.Center),
                decorationBox = {innerTextField ->
                    Column (modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color_Unelected,
                            shape = RoundedCornerShape(size = 20.dp)
                        )
                        .fillMaxWidth()
                        .padding(all = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(modifier = Modifier.wrapContentSize()){
                            if(textState.isEmpty())
                                Text(
                                    text = "이름을 입력해주세요.",
                                    fontFamily = font_pt,
                                    fontWeight = FontWeight.Light,
                                    fontSize = 13.sp,
                                    color = Color_Unelected,
                                    textAlign= TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            innerTextField()
                        }
                    }
                },
                modifier = Modifier.padding(bottom = 3.dp)
            )

            // -------------------------------------------------------------------------
            Button(
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Orange01),
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        MainApplication.getInstance().getDataStore().setText_name(textState)
                    }
                    navController.navigate(SETUNIVERSITY) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            ) {
                Text(text = "확인")
            }
        }
    }
}

@Composable
fun gallery(){
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier
            .wrapContentSize()
            .padding(top = 10.dp, bottom = 20.dp)
            .paint(
                painterResource(id = R.drawable.nyangfoot1),
                contentScale = ContentScale.FillBounds
            )
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_gallery),
            contentDescription = null,
            modifier = Modifier
                .wrapContentSize()
                .background(color = Orange01, shape = CircleShape)
                .clickable {
                    /*do Something*/
                }
        )
    }
}


@Composable
fun profile_textfield(){

}

@Preview(showBackground = true)
@Composable
internal fun setprofile_Preview(){
    //val navController = NavHostController
    MukatlistTheme{
        //profile()
    }
}

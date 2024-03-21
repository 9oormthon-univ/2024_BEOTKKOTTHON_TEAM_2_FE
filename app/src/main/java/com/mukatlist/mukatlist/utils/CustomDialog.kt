package com.mukatlist.mukatlist.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.mukatlist.mukatlist.initSetting.search_bar
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.R
import com.mukatlist.mukatlist.ui.theme.Color_Unelected
import com.mukatlist.mukatlist.ui.theme.Orange01
import com.mukatlist.mukatlist.ui.theme.font_pt

@Composable
fun Mukatlist_AlertDialog(){
    Dialog(
        onDismissRequest = {},
    ){
        Surface(
            modifier = Modifier,
            shape = RoundedCornerShape(15.dp),
            color = Color.White
        ) {
            AlertDialogContent("삭제하시겠습니까?")
        }
    }
}

@Composable
fun AlertDialogContent(string: String){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.wrapContentSize()
    ) {
        Column(

        ) {
            Text(text = "알림",
                fontFamily = font_pt,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
            )
            Text(text = string,
                fontFamily = font_pt,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 20.dp)
                    .fillMaxWidth()
            )
        }

        Row (
            modifier = Modifier.padding(all = 10.dp)
        ) {
            Button(
                colors =  ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.padding(end = 10.dp),
                border = BorderStroke(1.dp, Orange01),
                onClick = { /*TODO*/ }
            )
            {
                Text(
                    text = "취소",
                    color = Orange01,
                    fontFamily = font_pt,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.weight(4f))

            Button(
                colors =  ButtonDefaults.buttonColors(Orange01),
                modifier = Modifier.padding(start = 10.dp),
                onClick = { /*TODO*/ }
            )
            {
                Text(
                    text = "확인",
                    color = Color.White,
                    fontFamily = font_pt,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun Mukatlist_AlertDialog_Preview(){
    MukatlistTheme{
        Mukatlist_AlertDialog()
    }
}

@Composable
fun Mukatlist_EditDialog(){
    Dialog(onDismissRequest = {}){
        Surface(
            modifier = Modifier,
            shape = RoundedCornerShape(15.dp),
            color = Color.White
        ) {
            EditDialogContent("먹킷리스트 제목을 입력해 주세요.")
        }
    }
}

@Composable
fun EditDialogContent(string: String){
    var textState by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.wrapContentSize()
    ) {
        Column(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        ) {
            Text(text = "항목 생성",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
            )
            Text(text = string,
                fontFamily = font_pt,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 30.dp, bottom = 20.dp, start = 8.dp)
                    .fillMaxWidth()
            )
            BasicTextField(
                value = textState,
                onValueChange = {if (it.length > 15) textState else textState = it},
                textStyle = TextStyle(fontSize = 20.sp),
                decorationBox = {innerTextField ->
                    Column (modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color_Unelected,
                            shape = RoundedCornerShape(size = 15.dp)
                        )
                        .fillMaxWidth()
                        .padding(all = 10.dp),
                    ) {
                        Box(modifier = Modifier.wrapContentSize(),
                            contentAlignment = Alignment.Center){
                            if(textState.isEmpty())
                                androidx.compose.material3.Text(
                                    text = "텍스트를 입력해 주세요. (15자 제한)",
                                    fontFamily = font_pt,
                                    fontWeight = FontWeight.Light,
                                    fontSize = 13.sp,
                                    textAlign = TextAlign.Center,
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

        Row (
            modifier = Modifier.padding(all = 10.dp)
        ) {
            Button(
                colors =  ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.padding(end = 10.dp),
                border = BorderStroke(1.dp, Orange01),
                onClick = { /*TODO*/ }
            )
            {
                Text(
                    text = "취소",
                    color = Orange01,
                    fontFamily = font_pt,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.weight(4f))

            Button(
                colors =  ButtonDefaults.buttonColors(Orange01),
                modifier = Modifier.padding(start = 10.dp),
                onClick = { /*TODO*/ }
            )
            {
                Text(
                    text = "확인",
                    color = Color.White,
                    fontFamily = font_pt,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun Mukatlist_EditDialog_Preview(){
    MukatlistTheme{
        Mukatlist_EditDialog()
    }
}
package com.mukatlist.mukatlist.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukatlist.mukatlist.LoginActivity
import com.mukatlist.mukatlist.R
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.ui.theme.Orange01
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(){
    Row (modifier = androidx.compose.ui.Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            logo()
            Spacer(modifier = androidx.compose.ui.Modifier.padding(10.dp))
            button_kakaotalk()
        }

    }
}

@Composable
fun logo(){
    Surface {
        Column(
            androidx.compose.ui.Modifier.background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_splash),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = androidx.compose.ui.Modifier
            )
        }
    }
}

@Composable
fun button_kakaotalk(){
    val coroutineScope = rememberCoroutineScope()

    Button(
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(Orange01),
        contentPadding = PaddingValues(start = 90.dp, end = 90.dp, top = 10.dp, bottom = 10.dp),
        modifier = androidx.compose.ui.Modifier.wrapContentSize(),
        onClick = {
            coroutineScope.launch{
                LoginActivity().login()
            }
        }
    ) {
        Image(painter = painterResource(R.drawable. ic_share_kakaotalk), contentDescription = null)
        Spacer(modifier = androidx.compose.ui.Modifier.padding(7.dp))
        Text(text = "카카오로 로그인")
    }
}

@Preview(showBackground = true)
@Composable
internal fun LoginScreenPreview(){
    MukatlistTheme{
        LoginScreen()
    }
}

@Preview(showBackground = true)
@Composable
internal fun ButtonPreview(){
    MukatlistTheme{
        button_kakaotalk()
    }
}

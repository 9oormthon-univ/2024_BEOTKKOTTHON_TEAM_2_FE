package com.mukatlist.mukatlist.login

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mukatlist.mukatlist.LoginActivity
import com.mukatlist.mukatlist.R
import com.mukatlist.mukatlist.ui.theme.Orange01

@Composable
fun LoginScreen(content: () -> Unit){
    Row (modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            logo()
            Spacer(modifier = Modifier.padding(10.dp))
            button_google { content() }
        }
    }
}

@Composable
fun logo(){
    Surface {
        Column(
            Modifier.background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_splash),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun button_google(onClick: () -> Unit){
    Button(
        onClick = {
            onClick
        },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(Orange01),
        contentPadding = PaddingValues(start = 90.dp, end = 90.dp, top = 10.dp, bottom = 10.dp),
        modifier = Modifier.wrapContentSize(),
    ) {
        Image(painter = painterResource(R.drawable. ic_share_kakaotalk), contentDescription = null)
        Spacer(modifier = Modifier.padding(7.dp))
        Text(text = "Google로 로그인")
    }
}

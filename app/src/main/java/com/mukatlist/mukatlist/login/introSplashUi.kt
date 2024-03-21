package com.mukatlist.mukatlist.login


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import java.lang.reflect.Modifier

@Composable
fun profile(){
    Row (modifier = androidx.compose.ui.Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            logo()
        }

    }
}


//@Preview(showBackground = true)
//@Composable
//internal fun setProfileUiPreview(){
//    MukatlistTheme{
//        profile()
//    }
//}
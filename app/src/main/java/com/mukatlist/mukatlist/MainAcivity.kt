package com.mukatlist.mukatlist


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kakao.sdk.common.util.Utility
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.utils.PreferenceUtil
import com.mukatlist.mukatlist.utils.MukatlistApp

class MainActivity : ComponentActivity() {
    companion object{
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{}

    }

    override fun onStart() {
        super.onStart()
        setContent {
            MukatlistTheme {
                MukatlistApp()
            }
        }
    }
}

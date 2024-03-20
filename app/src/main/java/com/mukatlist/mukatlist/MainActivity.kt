package com.mukatlist.mukatlist


import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.utils.PreferenceUtil
import com.mukatlist.mukatlist.utils.MukatlistApp

open class MainActivity : ComponentActivity() {
    companion object{
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContent{
            LoginActivity().runUI()
            Log.d(TAG, "onCreate runUI 실행")

//            MukatlistTheme {
//                MukatlistApp()
//            }
        }
    }

    override fun onStart() {
        super.onStart()
        setContent {
            LoginActivity().runUI()
            Log.d(TAG, "onStart runUI 실행")
//            MukatlistTheme {
//                MukatlistApp()
//            }
        }
    }
}

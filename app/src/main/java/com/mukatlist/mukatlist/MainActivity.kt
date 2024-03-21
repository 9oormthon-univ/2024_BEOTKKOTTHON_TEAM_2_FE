package com.mukatlist.mukatlist

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kakao.sdk.common.KakaoSdk
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.utils.PreferenceUtil
import com.mukatlist.mukatlist.utils.MukatlistApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class MainActivity : ComponentActivity() {
    companion object{
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        setContent{
            LoginActivity().runUI()
            Log.d(TAG, "onCreate runUI 실행")
        }
    }

    fun onStart(savedInstanceState: Bundle?) {
        super.onStart()
        setContent{
            if( prefs.getName() != null && prefs.getUniversity() != null){

                MukatlistTheme {
                    Log.d(TAG, "onStart MukatlistApp 실행")
                    MukatlistApp()
                }
            }
            else {
                LoginActivity().runUI()
                Log.d(TAG, "onStart runUI 실행")
            }
        }
    }
}

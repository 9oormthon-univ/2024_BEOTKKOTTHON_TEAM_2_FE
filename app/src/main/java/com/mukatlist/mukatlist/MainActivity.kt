package com.mukatlist.mukatlist

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
import com.mukatlist.mukatlist.login.SplashScreen
import com.mukatlist.mukatlist.viewmodels.LoginViewModel
import kotlinx.coroutines.flow.first


open class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<LoginViewModel>()
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()

        // 로그인 시도
        viewModel.tryLogin(this)

        lifecycleScope.launchWhenCreated {
            viewModel.loginResult.collect { isLogin ->
                Log.e(TAG, "로그인 정보: $isLogin")
                val text_name = MainApplication.getInstance().getDataStore().text_name.first()
                val text_uni = MainApplication.getInstance().getDataStore().text_uni.first()
                Log.e(TAG, "text_name = $text_name")
                Log.e(TAG, "text_uni = $text_uni")


                if (isLogin && text_name != "" && text_uni != "") {
                    if (auth.currentUser != null) {
                        Log.e(TAG, "로그인 O")
                        startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                    }
                } else {
                    // 로그인 안되어있을 때 로그인 페이지 열림
                    Log.e(TAG, "로그인 X")
                    startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                }
            }
        }
    }
}

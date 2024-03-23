package com.mukatlist.mukatlist

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.accompanist.web.WebView
import com.mukatlist.mukatlist.utils.MukatlistApp

class HomeActivity: ComponentActivity() {
    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        WebView.setWebContentsDebuggingEnabled(true)

        super.onCreate(savedInstanceState)
        setContent{
            MukatlistApp(this)
        }
    }

}
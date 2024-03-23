package com.mukatlist.mukatlist.screen

import android.annotation.SuppressLint
import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

import com.google.accompanist.web.rememberWebViewState
import com.mukatlist.mukatlist.utils.WebAppInterface

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun MukatlistScreen(context: Context){
    //TODO: 링크 바꾸기
    val url = "https://2024-beotkkotthon-team-2-fe-3.vercel.app/"
    AndroidView(
        factory = {context ->
            WebView(context).apply {
                //TODO: 웹에 정보 보내기 => name, university
                addJavascriptInterface( WebAppInterface(context), "{수정할 부분}")

                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(true)
            }
        },
        update = { webView ->
            webView.loadUrl(url)
        }
    )
}
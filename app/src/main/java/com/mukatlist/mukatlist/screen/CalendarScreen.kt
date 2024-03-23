package com.mukatlist.mukatlist.screen

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.web.rememberWebViewState
import com.mukatlist.mukatlist.utils.WebAppInterface

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun CalendarScreen(){
    //TODO: 링크 바꾸기
    val url = "http://172.16.7.36:3000"
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
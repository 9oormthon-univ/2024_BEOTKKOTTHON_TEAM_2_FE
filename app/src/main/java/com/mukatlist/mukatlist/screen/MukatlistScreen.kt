package com.mukatlist.mukatlist.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun MukatlistScreen(){
    val webViewState =
        rememberWebViewState(
            url = "www.naver.com",
            additionalHttpHeaders = emptyMap() //HttpHeaders(AccessToken 등)
        )
    WebView(
        state = webViewState,
        modifier = Modifier.fillMaxSize()
    )
}
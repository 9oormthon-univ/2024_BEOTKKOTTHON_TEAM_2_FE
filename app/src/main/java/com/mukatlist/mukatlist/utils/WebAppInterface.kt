package com.mukatlist.mukatlist.utils

import android.content.Context
import android.webkit.JavascriptInterface

public class WebAppInterface(context: Context) {
    lateinit var mContext: Context

    fun WebAppInterface(c: Context) {
        mContext = c
    }

    @JavascriptInterface
    fun sendDataToAndroid(data: String?) {
        // TODO: 여기에 안드로이드에서 수신한 데이터에 대한 처리 작업을 수행합니다.
    }

}
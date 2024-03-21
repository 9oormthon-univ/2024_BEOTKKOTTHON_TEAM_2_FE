package com.mukatlist.mukatlist

import android.app.Application
import com.kakao.sdk.common.KakaoSdk


class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Kakao SDK 초기화
        KakaoSdk.init(this, "kakao6368a6f2f7c829fb4de02e5ff439e2cb")
    }
}
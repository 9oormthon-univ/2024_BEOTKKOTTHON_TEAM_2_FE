package com.mukatlist.mukatlist

import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.auth.model.OAuthToken
import android.content.ContentValues.TAG
import androidx.compose.runtime.Composable
import com.mukatlist.mukatlist.login.intro
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme

class LoginActivity: MainActivity() {

    private val mCallback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.e(TAG, "로그인 실패 $error")
        } else if (token != null) {
            Log.d(TAG, "로그인 성공 ${token.accessToken}")
            HomFragment()
        }
    }

    @Composable
    fun runUI(){
        MukatlistTheme{
            intro()
            Log.e(ContentValues.TAG, "intro 실행")
        }
    }

    fun login(){
        Log.d(ContentValues.TAG, "login 실행")
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                if (error != null) {
                    Log.e(TAG, "로그인 실패 $error")
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    } else {
                        UserApiClient.instance.loginWithKakaoAccount(this, callback = mCallback)
                    }
                } else if (token != null) {
                    Log.d(TAG, "로그인 성공 ${token.accessToken}")
                    Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                    HomFragment()
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = mCallback)
        }
    }
}
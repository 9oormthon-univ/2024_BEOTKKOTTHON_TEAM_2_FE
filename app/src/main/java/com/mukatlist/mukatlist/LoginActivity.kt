package com.mukatlist.mukatlist

import android.util.Log
import android.widget.Toast
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.auth.model.OAuthToken
import android.content.ContentValues.TAG
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.mukatlist.mukatlist.login.LoginScreen
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.utils.MukatlistApp

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
            Log.e(TAG, "LoginScreen 실행")
            LoginScreen()
            Log.e(TAG, "LoginScreen 종료")
        }
    }

    fun login(){
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            Log.d(TAG, "login 실행")
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
                    requestUserData()
                }
            }
        } else {
            Log.d(TAG, "login 불가")
            UserApiClient.instance.loginWithKakaoAccount(this, callback = mCallback)
        }
    }

    fun requestUserData(){
        // 사용자 정보 요청 (기본)
        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(TAG, "사용자 정보 요청 실패", error)
            }
            else if (user != null) {
                Log.i(TAG, "사용자 정보 요청 성공" +
                        "\n회원번호: ${user.id}")
                setContent{
                    runMukatlist()
                }
            }
        }
    }

    @Composable
    fun runMukatlist(){
        MukatlistTheme {
            Log.d(TAG, "onCreate MukatlistApp 실행")
            MukatlistApp()
        }
    }
}
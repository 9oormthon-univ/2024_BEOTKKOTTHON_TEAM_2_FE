package com.mukatlist.mukatlist.viewmodels

import android.content.ContentValues
import android.content.Context
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.mukatlist.mukatlist.R
import com.mukatlist.mukatlist.login.LoginScreen
import com.mukatlist.mukatlist.ui.theme.MukatlistTheme
import com.mukatlist.mukatlist.utils.MukatlistApp
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel(){

    // 로그인 결과 반환 변수
    private val _loginResult = MutableSharedFlow<Boolean>()
    private val _isFailState = mutableStateOf(false)
    var loginResult = _loginResult.asSharedFlow()
    val isFailState: State<Boolean> = _isFailState

    fun tryLogin(context: Context) {
        viewModelScope.launch {
            val account = this.async {
                getLastSignedInAccount(context)
            }
            delay(2500)

            // 계정 확인: 있음 -> true, 없음 -> false 반환
            setLoginResult(account.await() != null)
        }
    }

    // 이전에 로그인 한 계정이 있는지 확인
    private fun getLastSignedInAccount(context: Context) = GoogleSignIn.getLastSignedInAccount(context)

    private fun setLoginResult(isLogin: Boolean) {
        viewModelScope.launch {
            _loginResult.emit(isLogin)
            Log.e(ContentValues.TAG, "setLoginResult: $isLogin")

        }
    }

    fun requestUserData(){

    }
}
package com.mukatlist.mukatlist.viewmodels

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.mukatlist.mukatlist.MainApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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
        Log.e(TAG, "tryLogin")

        viewModelScope.launch {
            Log.e(TAG, "viewModelScope")

            val account = this.async {
                getLastSignedInAccount(context)
            }
            Log.e(TAG, "account = $account")

            delay(1000)

            // 계정 확인: 있음 -> true, 없음 -> false 반환
            if (account.await() != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    var currentFirebaseUser: FirebaseUser?  = FirebaseAuth.getInstance().getCurrentUser()
                    val currentuser = currentFirebaseUser?.uid
                    Log.e(TAG, " account: $currentuser")

                    MainApplication.getInstance().getDataStore().setText_userID(currentuser.toString())
                }
            }
            else
                Log.e(TAG, "account.await()")
            setLoginResult(account.await() != null)
        }
    }

    // 이전에 로그인 한 계정이 있는지 확인
    private fun getLastSignedInAccount(context: Context) = GoogleSignIn.getLastSignedInAccount(context)

    private fun setLoginResult(isLogin: Boolean) {
        viewModelScope.launch {
            _loginResult.emit(isLogin)
            Log.e(TAG, "setLoginResult: $isLogin")

        }
    }
}
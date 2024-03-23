package com.mukatlist.mukatlist

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging
import com.mukatlist.mukatlist.ui.theme.FCM
import com.mukatlist.mukatlist.utils.remoteDB
import com.mukatlist.mukatlist.viewmodels.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


open class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<LoginViewModel>()
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val remoteDB: remoteDB =
        remoteDB()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        CoroutineScope(Dispatchers.IO).launch {
            MainApplication.getInstance().getDataStore().setText_fcm_token(FCM)
            Log.e("text_fcm_token", "text_fcm_token: ${MainApplication.getInstance().getDataStore().text_fcm_token.first()}")

        }
        // 로그인 시도
        viewModel.tryLogin(this)

        lifecycleScope.launchWhenCreated {
            viewModel.loginResult.collect { isLogin ->
                Log.e(TAG, "로그인 정보: $isLogin")
                val text_name = MainApplication.getInstance().getDataStore().text_name.first()
                val text_uni = MainApplication.getInstance().getDataStore().text_uni.first()
                val text_id = MainApplication.getInstance().getDataStore().text_userid.first()

                Log.e(TAG, "text_name = $text_name")
                Log.e(TAG, "text_uni = $text_uni")
                Log.e(TAG, "text_userid = $text_id")


                if (isLogin && text_name != "" && text_uni != "") {
                    if (auth.currentUser != null) {
                        Log.e(TAG, "로그인 O")
                        //TODO: 로그인 시 로그인 정보 전송
                        remoteDB.postLogin(text_id)
                        startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                    }
                } else {
                    // 로그인 안되어있을 때 로그인 페이지 열림
                    Log.e(TAG, "로그인 X")
                    startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                }
            }
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            // FCM SDK (and your app) can post notifications.
        } else {
            // TODO: Inform user that that your app will not show notifications.
        }
    }

    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(android.Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }

    private fun sendTest(){
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            Log.e("token", token)
            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
        })
    }

}

package com.mukatlist.mukatlist

import android.content.ContentValues
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.mukatlist.mukatlist.login.LoginScreen
import androidx.compose.runtime.*
import com.mukatlist.mukatlist.initSetting.check_Uni
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginActivity : ComponentActivity(), View.OnClickListener {
    // Firebase
    private lateinit var googleSignInClient: GoogleSignInClient
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val RC_SIGN_IN = 9001
    lateinit var currentuser: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_ui)
        val button = findViewById<Button>(R.id.google_login_button)

        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.google_login_button) {
                googleLogin()
            }
        }
    }

    // 로그인 객체 생성
    fun googleLogin() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        googleSignIn()
    }

    // 구글 회원가입
    private fun googleSignIn() {
        Log.e(ContentValues.TAG, "googleSignIn")

        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                Log.e(ContentValues.TAG, "onActivityResult: $account")
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
                Log.e(ContentValues.TAG, "$e")

                Toast.makeText(this, "구글 회원가입에 실패하였습니다: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        } else {
            Log.e(ContentValues.TAG, "onActivityResult - else")
        }
    }

    // account 객체에서 id 토큰 가져온 후 Firebase 인증
    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount?) {
        Log.e(ContentValues.TAG, "firebaseAuthWithGoogle")
        val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                toMainActivity(auth.currentUser)
            }
        }
    }

    fun toMainActivity(user: FirebaseUser?) {
        Log.e(ContentValues.TAG, "toMainActivity")
        CoroutineScope(Dispatchers.IO).launch {
            var currentFirebaseUser: FirebaseUser?  = FirebaseAuth.getInstance().getCurrentUser()
            val currentuser = currentFirebaseUser?.uid
            Log.e(ContentValues.TAG, "ID: $currentuser")
            MainApplication.getInstance().getDataStore().setText_userID(currentuser.toString())
        }
        if (user != null) {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }

}
//package com.mukatlist.mukatlist.utils
//
//import android.view.View
//import androidx.appcompat.app.AppCompatActivity
//import com.kakao.sdk.auth.model.OAuthToken
//
//class LoginKakao: AppCompatActivity(), View.OnClickListener  {
//    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
//
//    //KakaoSdk.init(this, 6368a6f2f7c829fb4de02e5ff439e2cb)
//
//    private val mCallback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
//        if (error != null) {
//            Log.e(Constants.TAG, "로그인 실패 $error")
//        } else if (token != null) {
//            Log.d(Constants.TAG, "로그인 성공 ${token.accessToken}")
//            nextMainActivity()
//        }
//    }
//
//    override fun onClick(v: View?) {
//        when (v?.id) {
//            binding.btnLogin.id -> {
//                if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
//                    UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
//                        if (error != null) {
//                            Log.e(Constants.TAG, "로그인 실패 $error")
//                            if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
//                                return@loginWithKakaoTalk
//                            } else {
//                                UserApiClient.instance.loginWithKakaoAccount(this, callback = mCallback)
//                            }
//                        } else if (token != null) {
//                            Log.d(Constants.TAG, "로그인 성공 ${token.accessToken}")
//                            Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
//                            nextMainActivity()
//                        }
//                    }
//                } else {
//                    UserApiClient.instance.loginWithKakaoAccount(this, callback = mCallback)
//                }
//            }
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        Log.d(Constants.TAG, "keyhash : ${Utility.getKeyHash(this)}")
//
//        KakaoSdk.init(this, Constants.APP_KEY)
//        if (AuthApiClient.instance.hasToken()) {
//            UserApiClient.instance.accessTokenInfo { _, error ->
//                if (error == null) {
//                    nextMainActivity()
//                }
//            }
//        }
//
//        setContentView(binding.root)
//
//        binding.btnLogin.setOnClickListener(this)
//    }
//
//    private fun nextMainActivity() {
//        startActivity(Intent(this, MainActivity::class.java))
//        finish()
//    }
//}
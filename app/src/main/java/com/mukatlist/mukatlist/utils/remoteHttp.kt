//package com.mukatlist.mukatlist.utils
//
//import android.R.id
//import android.util.Log
//import com.mukatlist.mukatlist.server.ApiService
//import okhttp3.MediaType
//import okhttp3.MultipartBody
//import okhttp3.RequestBody
//import org.json.JSONException
//import org.json.JSONObject
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//
//private const val TAG: String = "REMOTE DATA SOURCE"
//private val retrofit: Retrofit = Retrofit.Builder().baseUrl("http://43.202.65.80:3000")
//    .addConverterFactory(GsonConverterFactory.create()).build()
//private val retrofitAPI: ApiService = retrofit.create(ApiService::class.java)
//
//fun postRegister(
//    id: String,
//    name: String,
//    university: String,
//    fcm_Token: String,
//    onResponseSuccess: (
//        Map<String, Any>
//    ) -> Unit,
//) {
//    val map = HashMap<String, Any>()
//
//    val id_b: MultipartBody.Part =  MultipartBody.Part.createFormData("kakao_id", id)
//
//    map["kakao_id"] = id_b
//    val name_b: MultipartBody.Part = MultipartBody.Part.createFormData("user_Id", name)
//    map["user_Id"] = name_b
//    val university_b: MultipartBody.Part = MultipartBody.Part.createFormData("university_Name", university)
//    map["university_Name"] = university_b
//    val fcm_Token_b: MultipartBody.Part = MultipartBody.Part.createFormData("fcm_Token", fcm_Token)
//    map["fcm_Token"] = fcm_Token_b
//
//    val call: Call<Map<String, Any>> = retrofitAPI.post_register(
//        map
//    )
//
//    call.enqueue(object : Callback<Map<String, Any>?> {
//        override fun onResponse(
//            call: Call<Map<String, Any>?>,
//            response: Response<Map<String, Any>?>,
//        ) {
//            Log.d(TAG, "onResponse 성공")
//            if (response.isSuccessful) {
//                val responseBody = response.body()!!
//                onResponseSuccess(responseBody)
//            }
//        }
//
//        override fun onFailure(call: Call<Map<String, Any>?>, t: Throwable) {
//            Log.d(TAG, "onFailure 실패")
//        }
//    })
//}
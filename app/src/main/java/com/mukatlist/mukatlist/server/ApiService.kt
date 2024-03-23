package com.mukatlist.mukatlist.server

import com.mukatlist.mukatlist.data.item
import retrofit2.Call
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONArray
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

public interface ApiServices{

    @POST("/api/user/register")
    fun post_register(
        @Body registerRequest: RequestBody
    ): Call<ResponseBody?>?

    @POST("/api/user/login")
     fun post_login(
        @Body requestBody: RequestBody?
    ): Call<ResponseBody?>?

    @GET("/api/universities")
    fun get_university(): Call<String>

//    @GET("api/universities/university/{universityName}")
//    fun get_uni(
//
//    )

}
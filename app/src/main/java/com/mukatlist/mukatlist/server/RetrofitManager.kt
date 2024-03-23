package com.mukatlist.mukatlist.server

import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.Arrays
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


class RetrofitManager {
    lateinit var retrofit: Retrofit
    lateinit var apiService: ApiServices

    var builder: Retrofit.Builder = Builder()
        .baseUrl("http://43.202.65.80:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .client(createTrustingOkHttpClient())

    init {
        retrofit = builder.build()
        apiService = retrofit.create(ApiServices::class.java)
    }

    private fun createTrustingOkHttpClient(): OkHttpClient {
        return try {
            val x509TrustManager: X509TrustManager = object : X509TrustManager {
                override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {}
                override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {}
                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            }
            val trustAllCerts = arrayOf<TrustManager>(
                x509TrustManager
            )
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())
            OkHttpClient.Builder()
                .sslSocketFactory(sslContext.socketFactory, x509TrustManager)
                .hostnameVerifier { hostname: String?, session: SSLSession? -> true }
                .build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}
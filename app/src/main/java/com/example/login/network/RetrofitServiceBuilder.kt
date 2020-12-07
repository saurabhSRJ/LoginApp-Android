package com.example.login.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


private const val BASE_URL = "https://preprod-boss-auth.blackbuck.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


var interceptor = Interceptor { chain ->
    val newRequest: Request =
        chain.request().newBuilder().addHeader("X-Consumer-Tenant-Id", "boss")
            .addHeader("App-Version", "215")
            .addHeader("Accept-Language",  "en")
            .addHeader("Content-Type", "application/json")
            .build()
    chain.proceed(newRequest)
}

var httpClient : OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(httpClient)
    .build()

object ServiceBuilder{
    val retrofitClient : LoginApiService by lazy { retrofit.create(LoginApiService::class.java) }
}
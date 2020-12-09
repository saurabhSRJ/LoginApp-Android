package com.example.login.sharedPreferences

import android.content.Context
import android.content.SharedPreferences
import com.example.login.model.UserDetailResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class Prefs(context : Context) {
    private val PREFS_FILENAME = "com.example.login.prefs"
    private val MOBILE_NUMBER = "mobile_number"
    private val SESSION_TOKEN = "session_token"
    private val USER_DETAILS = "user_details"
    private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    private val jsonAdapter : JsonAdapter<UserDetailResponse> = moshi.adapter(UserDetailResponse::class.java)
    val prefs : SharedPreferences = context.getSharedPreferences(PREFS_FILENAME,Context.MODE_PRIVATE)

    var mobileNumber : String
        get() = prefs.getString(MOBILE_NUMBER, "") ?: ""
        set(value) = prefs.edit().putString(MOBILE_NUMBER,value).apply()

    var sessionToken : String
        get() = prefs.getString(SESSION_TOKEN,"") ?: ""
        set(value) = prefs.edit().putString(SESSION_TOKEN,value).apply()

    var userDetails : UserDetailResponse?
        get() {
            val jsonString = prefs.getString(USER_DETAILS,"")
            return jsonAdapter.fromJson(jsonString)
        }
        set(value) = prefs.edit().putString(USER_DETAILS,jsonAdapter.toJson(value)).apply()
}
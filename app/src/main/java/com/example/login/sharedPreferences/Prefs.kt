package com.example.login.sharedPreferences

import android.content.Context
import android.content.SharedPreferences

class Prefs(context : Context) {
    private val PREFS_FILENAME = "com.example.login.prefs"
    private val MOBILE_NUMBER = "mobile_number"
    val prefs : SharedPreferences = context.getSharedPreferences(PREFS_FILENAME,Context.MODE_PRIVATE)

    var mobileNumber : String
        get() = prefs.getString(MOBILE_NUMBER, "") ?: ""
        set(value) = prefs.edit().putString(MOBILE_NUMBER,value).apply()
}
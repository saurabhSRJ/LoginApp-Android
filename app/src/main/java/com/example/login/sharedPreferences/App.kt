package com.example.login.sharedPreferences

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AlertDialog

class App : Application() {
    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
//        if (isNetworkConnected()) {
//
//            AlertDialog.Builder(this).setTitle("No Internet Connection")
//                    .setMessage("Please check your internet connection and try again")
//                    .setPositiveButton(android.R.string.ok) { _, _ -> }
//                    .setIcon(android.R.drawable.ic_dialog_alert).show()
//        }
    }


    @SuppressLint("NewApi")
    private fun isNetworkConnected(): Boolean {
        //1
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        //2
        val activeNetwork = connectivityManager.activeNetwork
        //3
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        //4
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}
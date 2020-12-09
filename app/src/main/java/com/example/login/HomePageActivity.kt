package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.login.databinding.ActivityHomePageBinding
import com.example.login.sharedPreferences.App
import com.example.login.sharedPreferences.Prefs

class HomePageActivity : AppCompatActivity() {
    val prefs: Prefs by lazy {
        App.prefs!!
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        @Suppress("UNUSED_VARIABLE")
        val binding : ActivityHomePageBinding = DataBindingUtil.setContentView(this,R.layout.activity_home_page)
        binding.apply { welcomeText.text = "Welcome "+ (prefs.userDetails?.name ) }
    }
}
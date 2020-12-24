package com.example.login


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.login.databinding.ActivityMainBinding
import com.example.login.databinding.FragmentRegistrationBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
//        val navController = this.findNavController(R.id.myNavFragment)
//        NavigationUI.setupActionBarWithNavController(this,navController)
        val binding : ActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = this.findNavController(R.id.myNavFragment)
//        return navController.navigateUp()
//    }
}